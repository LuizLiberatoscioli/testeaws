package com.aws.demo.response;

public class AtualizarTarefaResponse {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String criador;
	private int quantidadeHorasEstimadas;
	private String status;
	private String responsavel;
	private Integer quantidadeHorasRealizadas;
	
	public static class AtualizarTarefaResponseBuilder {
		private Long id;
		private String titulo;
		private String descricao;
		private String criador;
		private int quantidadeHorasEstimadas;
		private String status;
		private String responsavel;
		private Integer quantidadeHorasRealizadas;
		
		public AtualizarTarefaResponseBuilder setId (Long id) {
			this.id = id;
			return this;
		}
		
		public int getQuantidadeHorasRealizadas() {
			return quantidadeHorasRealizadas;
		}

		public void setQuantidadeHorasRealizadas(Integer quantidadeHorasRealizadas) {
			this.quantidadeHorasRealizadas = quantidadeHorasRealizadas;
		}

		public Long getId() {
			return id;
		}

		public String getTitulo() {
			return titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public String getCriador() {
			return criador;
		}

		public int getQuantidadeHorasEstimadas() {
			return quantidadeHorasEstimadas;
		}

		public String getStatus() {
			return status;
		}

		public String getResponsavel() {
			return responsavel;
		}

		public AtualizarTarefaResponseBuilder setTitulo (String titulo) {
			this.titulo = titulo;
			return this;
		}
		public AtualizarTarefaResponseBuilder setDescricao (String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public AtualizarTarefaResponseBuilder setCriador (String criador) {
			this.criador = criador;
			return this;
		}
		
		public AtualizarTarefaResponseBuilder setStatus (String status) {
			this.status = status;
			return this;
		}
		public AtualizarTarefaResponseBuilder setResponsavel (String responsavel) {
			this.responsavel = responsavel;
			return this;
		}
		public AtualizarTarefaResponseBuilder setQuantidadeHorasEstimadas (int quantidadeHorasEstimadas) {
			this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
			return this;
		}
		public AtualizarTarefaResponseBuilder setQuantidadeHorasRealizada (Integer quantidadeHorasRealizadas) {
			this.quantidadeHorasRealizadas = quantidadeHorasRealizadas;
			return this;
		}
		public AtualizarTarefaResponse build() {
			return new AtualizarTarefaResponse();
		}
	
	}

}
