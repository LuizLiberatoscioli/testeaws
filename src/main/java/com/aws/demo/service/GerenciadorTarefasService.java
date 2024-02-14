package com.aws.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aws.demo.Status.TarefasStatusEnum;
import com.aws.demo.entity.Tarefa;
import com.aws.demo.repository.GerenciadorTarefasRepository;

import jakarta.transaction.Transactional;
import request.AtualizarTarefaRequest;
import request.CadastrarTarefaRequest;

@Service
@Transactional
public class GerenciadorTarefasService {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	@Autowired
	private GerenciadorTarefasRepository gereciadorTarefasRepository;
	
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
	
	public Page<Tarefa> obtemTodasTarefasPorTitulo(String titulo , Pageable pegeable){
		return this.gereciadorTarefasRepository.findByTituloContaining(titulo, pegeable);
	}
	
	public Page<Tarefa> obtemTodasTarefas( Pageable pegeable){
		return this.gereciadorTarefasRepository.findAll( pegeable);
	}
	
	public Tarefa atualizarTarefa(Long id, AtualizarTarefaRequest request){
		
		Tarefa tarefa = new Tarefa.TarefaBuilder()
				.setQuantidadeHorasEstimadas(request.getQuantidadeHorasEstimadas())
				.setStatus(request.getStatus())
				.setTitulo(request.getTitulo())
				.setDescricao(request.getDescricao())
				.setResponsavel(request.getResponsavel())
				.build();
		
		 return this.gereciadorTarefasRepository.save(tarefa);
	}
	
	public void excluirTarefa(Long id){
		 this.gereciadorTarefasRepository.deleteById(id);
	}

	
	
}
