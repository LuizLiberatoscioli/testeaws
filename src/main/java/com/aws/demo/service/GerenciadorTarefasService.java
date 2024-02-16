package com.aws.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aws.demo.Status.TarefasStatusEnum;
import com.aws.demo.entity.Tarefa;
import com.aws.demo.excecoes.NaoPermitidoAlterarStatusException;
import com.aws.demo.excecoes.NaoPermitirExcluirException;
import com.aws.demo.excecoes.TarefaExistenteException;
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
	
	//criar
	public Tarefa salvarTarefa(CadastrarTarefaRequest request) {
		
		Tarefa tarefaValidacao = gereciadorTarefasRepository.findByTItuloOrDescricao(request.getTitulo(), request.getDescricao());
		
		if (tarefaValidacao != null) {
			throw new TarefaExistenteException("Ja existe uma tarefa com o mesmo titulo ou descricao");
		}
		
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
		return this.gereciadorTarefasRepository.findByTituloContainingOrderByDataAtualizacaoDesc(titulo, pegeable);
	}
	
	public Page<Tarefa> obtemTodasTarefas( Pageable pegeable){
		return this.gereciadorTarefasRepository.findAll( pegeable);
	}
	
	public Tarefa atualizarTarefa(Long id, AtualizarTarefaRequest request){
		
		Tarefa tarefa = this.gereciadorTarefasRepository.findById(id).get();
		
		if (tarefa.getStatus().equals(TarefasStatusEnum.FINALIZADA)) {
			throw new NaoPermitidoAlterarStatusException("Nao permitido mover a tarefa que esta FINALIZADA");
		}
		
		if (tarefa.getStatus().equals(TarefasStatusEnum.CRIADA) && request.getStatus().equals(TarefasStatusEnum.FINALIZADA)) {
			throw new NaoPermitidoAlterarStatusException("Nao permitido mover a tarefa para FINALIZADA se ela estiver com status de CRIADA");
		}
		
		if (tarefa.getStatus().equals(TarefasStatusEnum.BLOQUEADA) && request.getStatus().equals(TarefasStatusEnum.FINALIZADA)) {
			throw new NaoPermitidoAlterarStatusException("Nao permitido mover a tarefa para FINALIZADA se ela estiver com status de BLOQUEADA");
		}
		
		tarefa.setQuantidadeHorasEstimadas(request.getQuantidadeHorasEstimadas());
		tarefa.setStatus(request.getStatus());
		tarefa.setTitulo(request.getTitulo());
		tarefa.setDescricao(request.getDescricao());
		tarefa.setResponsavel(request.getResponsavel());
		tarefa.setQuantidadeHorasRealizada(request.getQuantidadeHorasRealizada());
		
		 return this.gereciadorTarefasRepository.save(tarefa);
	}
	
	public void excluirTarefa(Long id){
		 
		 
		 Tarefa tarefa = this.gereciadorTarefasRepository.findById(id).get();
		 
		 if (TarefasStatusEnum.CRIADA.equals(tarefa.getStatus())) {
			 throw new NaoPermitirExcluirException();
		 }
		 
		 this.gereciadorTarefasRepository.deleteById(id);
	}

	
	
}
