package com.aws.demo.controller;

import java.util.List;

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
	
	
	/*
	 * @GetMapping public ResponseEntity<List<ObterTarefasResponse>> obterTarefas(
	 * 
	 * @RequestParam(required = true) String titulo,
	 * 
	 * @RequestParam(defaultValue = "0") int pagina,
	 * 
	 * @RequestParam(defaultValue = "3") int size
	 * 
	 * ){
	 * 
	 * 
	 * Page<Tarefa> tarefas =this.gerenciadorTarefasService.obtemTarefas(titulo,
	 * PageRequest.of(pagina, size));
	 * 
	 * tarefas .stream() .map(tarefa -> {
	 * ObterTarefasResponse.ObterTarefasResponseBuilder
	 * 
	 * }).toList();
	 * 
	 * return null;
	 * 
	 * }
	 */
	 
	@GetMapping
    public ResponseEntity<ObterTarefasPaginadaResponse> obterTarefas(
            @RequestParam(required = false) String titulo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size){

       Page<Tarefa> tarefasPaginada = null;

       if ( titulo == null ) {
           tarefasPaginada = this.gerenciadorTarefasService.obtemTodasTarefas(PageRequest.of(page, size));
       } else {
           tarefasPaginada = this.gerenciadorTarefasService.obtemTarefasPorTitulo(titulo, PageRequest.of(page, size));
       }

        List<ObterTarefasResponse> tarefas = tarefasPaginada
                .getContent()
                .stream()
                .map(tarefa -> {
                   return ObterTarefasResponse
                            .builder()
                            .id(tarefa.getId())
                            .titulo(tarefa.getTitulo())
                            .descricao(tarefa.getDescricao())
                            .responsavel(tarefa.getResponsavel() != null ?tarefa.getResponsavel().getUsername() : "NAO_ATRIBUIDA")
                            .criador(tarefa.getCriador().getUsername())
                            .status(tarefa.getStatus())
                            .quantidadeHorasEstimadas(tarefa.getQuantidadeHorasEstimadas())
                            .quantidadeHorasRealizada(tarefa.getQuantidadeHorasRealizada())
                            .dataCadasto(tarefa.getDataCadasto())
                            .dataAtualizacao(tarefa.getDataAtualizacao())
                            .build();
                })
                .toList();

        ObterTarefasPaginadaResponse response = ObterTarefasPaginadaResponse
                .builder()
                .paginaAtual(tarefasPaginada.getNumber())
                .totalPaginas(tarefasPaginada.getTotalPages())
                .totalItens(tarefasPaginada.getTotalElements())
                .tarefas(tarefas)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
