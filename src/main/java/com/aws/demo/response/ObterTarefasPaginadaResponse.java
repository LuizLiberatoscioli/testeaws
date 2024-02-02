package com.aws.demo.response;

import java.util.List;

public class ObterTarefasPaginadaResponse {
	
	private int paginaAtual;
	private Long totalItens;
	private int totalPaginas;
	private List<ObterTarefasResponse> tarefas;
	
	public List<ObterTarefasResponse> getTarefas() {
		return tarefas;
	}


	public void setTarefas(List<ObterTarefasResponse> tarefas) {
		this.tarefas = tarefas;
	}


	private ObterTarefasPaginadaResponse (ObterTarefasPaginadaResponseBuilder builder) {
		this.paginaAtual = paginaAtual;
		this.totalItens = totalItens;
		this.totalPaginas = totalPaginas;
		this.tarefas = tarefas;
	}
	
	
	public int getPaginaAtual() {
		return paginaAtual;
	}
	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}
	public Long getTotalItens() {
		return totalItens;
	}
	public void setTotalItens(Long totalItens) {
		this.totalItens = totalItens;
	}
	public int getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	
	public static class ObterTarefasPaginadaResponseBuilder {
		private int paginaAtual;
		private Long totalItens;
		private int totalPaginas;
		private List<ObterTarefasResponse> tarefas;
		
		
		public int getPaginaAtual () {
			return paginaAtual;
		}
		
		public ObterTarefasPaginadaResponseBuilder setPaginaAtual (int paginaAtual) {
			this.paginaAtual = paginaAtual;
			return this;
		}
		
		public Long getTotalItens () {
			return totalItens;
		}
		public ObterTarefasPaginadaResponseBuilder setTotalItens (Long totalItens) {
			this.totalItens = totalItens;
			return this;
		}
		
		public int totalPaginas () {
			return totalPaginas;
		}
		
		public ObterTarefasPaginadaResponseBuilder setTotalPaginas (int totalPaginas) {
			this.totalPaginas = totalPaginas;
			return this;
		}
		public  List<ObterTarefasResponse> getTarefas () {
			return tarefas;
			
		}
		public ObterTarefasPaginadaResponseBuilder setObterTarefas (List<ObterTarefasResponse> tarefas) {
			this.tarefas = tarefas;
			return this;
			
		}
		
		public  ObterTarefasPaginadaResponse build () {
			return new ObterTarefasPaginadaResponse(this);
		}
	}
	
	

}
