package com.aws.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aws.demo.entity.Tarefa;
import com.aws.demo.entity.Usuario;
import com.aws.demo.repository.GerenciadorTarefasRepository;
import com.aws.demo.response.AtualizarTarefaResponse;
import com.aws.demo.response.CadastrarTarefaResponse;
import com.aws.demo.response.ObterTarefasPaginadaResponse;
import com.aws.demo.response.ObterTarefasPaginadaResponse.ObterTarefasPaginadaResponseBuilder;
import com.aws.demo.response.ObterTarefasResponse;
import com.aws.demo.response.ObterTarefasResponse.ObterTarefasResponseBuilder;
import com.aws.demo.service.GerenciadorTarefasService;

import jakarta.validation.Valid;
import request.AtualizarTarefaRequest;
import request.CadastrarTarefaRequest;

@RestController
@RequestMapping("/gerenciador-tarefas")
public class GerenciadorTarefasController {
	
	@Autowired
	private GerenciadorTarefasService gerenciadorTarefasService;
	
	@Autowired
	private GerenciadorTarefasRepository gerenciadorTarefasRepository;
	
	@PostMapping
	public ResponseEntity<Tarefa> salvarTarefa(@Valid @RequestBody CadastrarTarefaRequest request){
		Tarefa tarefaSalva = gerenciadorTarefasService.salvarTarefa(request);
		
		CadastrarTarefaResponse response = new CadastrarTarefaResponse.CadastrarTarefaResponseBuilder()
				.setId(request.getCriadorId())
				.setTitulo(request.getTitulo())
				.setDescricao(request.getDescricao())
				.setCriador(request.getCriadorId().toString())
				.build();

		return new ResponseEntity<>( tarefaSalva, HttpStatus.CREATED);
	}
	
	  @GetMapping 
	  public ResponseEntity<ObterTarefasPaginadaResponse> obterTarefas( 
			  @RequestParam(required = true) String titulo,
			  @RequestParam(defaultValue = "0") int pagina,
			  @RequestParam(defaultValue = "3") int size){
	    
	  Page<Tarefa> tarefasPaginada = null;
	  
	  if (titulo == null) {
		  tarefasPaginada =this.gerenciadorTarefasService.obtemTodasTarefas(
				  PageRequest.of(pagina, size));
	  }else {
		  tarefasPaginada =this.gerenciadorTarefasService.obtemTodasTarefasPorTitulo(titulo,
				  PageRequest.of(pagina, size));
	  }
	  
	 List<ObterTarefasResponse> tarefas = tarefasPaginada
	  .getContent()
	  .stream()
	  .map(tarefa -> {
		  
		  ObterTarefasResponseBuilder tarefasResponseBuilder = new ObterTarefasResponseBuilder();
		  tarefasResponseBuilder.setId(tarefa.getId());
		  tarefasResponseBuilder.setTitulo(tarefa.getTitulo());
		  tarefasResponseBuilder.setDescricao(tarefa.getDescricao());
		  tarefasResponseBuilder.setStatus(tarefa.getStatus());
		  tarefasResponseBuilder.setResponsavel(tarefa.getResponsavel());
		  tarefasResponseBuilder.setCriador(tarefa.getCriador());
		  tarefasResponseBuilder.setQuantidadeHorasEstimadas(tarefa.getQuantidadeHorasEstimadas());
		  
		  return tarefasResponseBuilder.build();
		  
	  })
	  .collect(Collectors.toList());
	 
		  ObterTarefasPaginadaResponseBuilder tarefasPaginadaBuilder = new ObterTarefasPaginadaResponseBuilder();
		  
		  tarefasPaginadaBuilder.setPaginaAtual(tarefasPaginada.getNumber());
		  tarefasPaginadaBuilder.setTotalPaginas(tarefasPaginada.getTotalPages());
		  tarefasPaginadaBuilder.setTotalItens(tarefasPaginada.getTotalElements());
		  tarefasPaginadaBuilder.setObterTarefas(tarefas);
	 	 
	return new ResponseEntity<>(tarefasPaginadaBuilder.build(), HttpStatus.OK);
	  
	  }
	  
	  
	  @PutMapping(value = "/{id}")
		public ResponseEntity<AtualizarTarefaResponse> atualizarTarefa(@PathVariable Long id,@Valid @RequestBody AtualizarTarefaRequest request){
			Tarefa tarefaAtualizada = gerenciadorTarefasService.atualizarTarefa(id,request);
			
			AtualizarTarefaResponse response = new AtualizarTarefaResponse.AtualizarTarefaResponseBuilder()
					.setId(tarefaAtualizada.getId())
					.setTitulo(tarefaAtualizada.getTitulo())
					.setDescricao(tarefaAtualizada.getDescricao())
					.setCriador(tarefaAtualizada.getCriador().toString())
					.setQuantidadeHorasEstimadas(tarefaAtualizada.getQuantidadeHorasEstimadas())
					.setStatus(tarefaAtualizada.getStatus().toString())
					.setResponsavel(tarefaAtualizada.getResponsavel().getUsername())
					.setQuantidadeHorasRealizada(tarefaAtualizada.getQuantidadeHorasRealizada())
					.build();

			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	  
	  @DeleteMapping(value = "/{id}")
		public void excluirTarefa(@PathVariable Long id) {
			gerenciadorTarefasService.excluirTarefa(id);
			
			
		}

}
