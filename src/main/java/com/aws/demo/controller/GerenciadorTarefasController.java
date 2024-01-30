package com.aws.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aws.demo.entity.Tarefa;
import com.aws.demo.response.CadastrarTarefaResponse;
import com.aws.demo.response.ObterTarefasResponse;
import com.aws.demo.response.ObterTarefasResponse.ObterTarefasResponseBuilder;
import com.aws.demo.service.GerenciadorTarefasService;

import request.CadastrarTarefaRequest;

@RestController
@RequestMapping("/gerenciador-tarefas")
public class GerenciadorTarefasController {
	
	@Autowired
	private GerenciadorTarefasService gerenciadorTarefasService;
	
	@PostMapping
	public ResponseEntity<Tarefa> salvarTarefa(@RequestBody CadastrarTarefaRequest request){
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
	  public ResponseEntity<List<ObterTarefasResponse>> obterTarefas( 
			  @RequestParam(required = true) String titulo,
			  @RequestParam(defaultValue = "0") int pagina,
			  @RequestParam(defaultValue = "3") int size){
	  
	  
	  Page<Tarefa> tarefas = this.gerenciadorTarefasService.obtemTarefas(titulo,
	  PageRequest.of(pagina, size));
	  
	 List<ObterTarefasResponse> response = tarefas
	  .stream()
	  .map(tarefa -> {
		  
		  ObterTarefasResponseBuilder builder = new ObterTarefasResponseBuilder();
		  builder.setTitulo(tarefa.getTitulo());
		  builder.setDescricao(tarefa.getDescricao());
		  builder.setStatus(tarefa.getStatus());
		  builder.setResponsavel(tarefa.getResponsavel());
		  
		  
		  builder.setCriador(tarefa.getCriador());
		  builder.setQuantidadeHorasEstimadas(tarefa.getQuantidadeHorasEstimadas());
		  
		  return builder.build();
		  
	  
	  })
	  .collect(Collectors.toList());
	return new ResponseEntity<>(response, HttpStatus.OK);
	 
	  
	  
	  }
	 
	 


}
