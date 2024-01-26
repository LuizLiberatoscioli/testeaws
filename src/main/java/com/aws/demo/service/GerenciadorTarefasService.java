package com.aws.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aws.demo.Status.TarefasStatusEnum;
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
				.setStatus(TarefasStatusEnum.CRIADA)
				.setTitulo(request.getTitulo())
				.setDescricao(request.getDescricao())
				.setCriador(usuarioService.obterUsuarioId(request.getCriadorId()).get())
				.build();
		
		return this.gereciadorTarefasRepository.save(tarefa);
		
	}
	
	public Page<Tarefa> obtemTarefas(String titulo , Pageable pegeable){
		return this.gereciadorTarefasRepository.findByTituloContaining(titulo, pegeable);
	}

	
	
}