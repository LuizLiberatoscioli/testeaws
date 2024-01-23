package com.aws.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.demo.entity.Tarefa;
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
		return new ResponseEntity<>( tarefaSalva, HttpStatus.CREATED);
	}

}
