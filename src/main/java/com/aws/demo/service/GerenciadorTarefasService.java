package com.aws.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.demo.entity.Tarefa;
import com.aws.demo.repository.GereciadorTarefasRepository;

import jakarta.transaction.Transactional;
import request.CadastrarTarefaRequest;

@Service
@Transactional
public class GerenciadorTarefasService {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@Autowired
	private GereciadorTarefasRepository gereciadorTarefasRepository;
	
	public Tarefa salvarTarefa(CadastrarTarefaRequest request) {
		
		Tarefa tarefa = new Tarefa.TarefaBuilder()
				.setQuantidadeHorasEstimadas(request.getQuantidadeHorasEstimadas())
				.setStatus(request.getStatus())
				.setTitulo(request.getTitulo())
				.setDescricao(request.getDescricao())
				.setResponsavel(usuarioService.obterUsuarioId(request.getResponsavelId()).get())
				.setCriador(usuarioService.obterUsuarioId(request.getCriadorId()).get())
				.build();
		
		return this.gereciadorTarefasRepository.save(tarefa);
		
	}

	
	
}
