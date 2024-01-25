package com.aws.demo.response;

public class CadastrarTarefaResponse {

	private Long id;
	private String titulo;
	private String descricao;
	private String criador;

	private CadastrarTarefaResponse(CadastrarTarefaResponseBuilder builder) {
		this.id = builder.id;
		this.titulo = builder.titulo;
		this.descricao = builder.descricao;
		this.criador = builder.criador;
	}

	public static class CadastrarTarefaResponseBuilder {
		private Long id;
		private String titulo;
		private String descricao;
		private String criador;

		public CadastrarTarefaResponseBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public CadastrarTarefaResponseBuilder setTitulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public CadastrarTarefaResponseBuilder setDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public CadastrarTarefaResponseBuilder setCriador(String criador) {
			this.criador = criador;
			return this;
		}
		
		public CadastrarTarefaResponse build() {
			return new CadastrarTarefaResponse(this);
		}
	}

}
