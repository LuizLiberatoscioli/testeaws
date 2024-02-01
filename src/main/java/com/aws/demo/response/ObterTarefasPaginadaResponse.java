package com.aws.demo.response;

import java.util.List;

public class ObterTarefasPaginadaResponse {
	
	private String paginaAtual;
	private String totalItens;
	private String totalPaginas;
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
	
	
	public String getPaginaAtual() {
		return paginaAtual;
	}
	public void setPaginaAtual(String paginaAtual) {
		this.paginaAtual = paginaAtual;
	}
	public String getTotalItens() {
		return totalItens;
	}
	public void setTotalItens(String totalItens) {
		this.totalItens = totalItens;
	}
	public String getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(String totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	
	public static class ObterTarefasPaginadaResponseBuilder {
		private String paginaAtual;
		private String totalItens;
		private String totalPaginas;
		private List<ObterTarefasResponse> tarefas;
		
		
		public String getPaginaAtual () {
			return paginaAtual;
		}
		
		public ObterTarefasPaginadaResponseBuilder setPaginaAtual (String paginaAtual) {
			this.paginaAtual = paginaAtual;
			return this;
		}
		
		public String getTotalItens () {
			return totalItens;
		}
		public ObterTarefasPaginadaResponseBuilder setTotalItens (String totalItens) {
			this.totalItens = totalItens;
			return this;
		}
		
		public String totalPaginas () {
			return totalPaginas;
		}
		
		public ObterTarefasPaginadaResponseBuilder setTotalPaginas (String totalPaginas) {
			this.totalPaginas = totalPaginas;
			return this;
		}
		public  List<ObterTarefasResponse> getTarefas () {
			return tarefas;
			
		}
		public ObterTarefasPaginadaResponseBuilder setObterTarefasResponse (List<ObterTarefasResponse> tarefas) {
			this.tarefas = tarefas;
			return this;
			
		}
		
		public  ObterTarefasPaginadaResponse builder () {
			return new ObterTarefasPaginadaResponse(this);
		}
	}
	
	

}
