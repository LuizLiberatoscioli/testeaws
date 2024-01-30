package com.aws.demo.response;

import java.time.LocalTime;

import com.aws.demo.Status.TarefasStatusEnum;
import com.aws.demo.entity.Usuario;

public class ObterTarefasResponse {

	private Long id;
	private String titulo;
	private String descricao;
	private TarefasStatusEnum status;
	private Usuario responsavel ;
	private Usuario criador ;
	private int quantidadeHorasEstimadas;
	private Integer quantidadeHorasRealizada;
	private LocalTime dataCadastro ;
	private LocalTime dataAtualizacao;
	
	private ObterTarefasResponse(ObterTarefasResponseBuilder builder) {
		this.quantidadeHorasEstimadas = builder.quantidadeHorasEstimadas;
		this.status = builder.status;
		this.titulo = builder.titulo;
		this.descricao = builder.descricao;
		this.responsavel = builder.responsavel;
		this.criador = builder.criador;
	}
	
	public static class ObterTarefasResponseBuilder {
		private int quantidadeHorasEstimadas;
		private TarefasStatusEnum status;
		private String titulo;
		private String descricao;
		private Usuario responsavel;
		private Usuario criador;
		
		public int getQuantidadeHorasEstimadas() {
			return quantidadeHorasEstimadas;
		}

		public TarefasStatusEnum getStatus() {
			return status;
		}

		public String getTitulo() {
			return titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public Usuario getResponsavel() {
			return responsavel;
		}

		public Usuario getCriador() {
			return criador;
		}

		public ObterTarefasResponseBuilder setQuantidadeHorasEstimadas(int quantidadeHorasEstimadas) {
			this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
			return this;
		}
		
		public ObterTarefasResponseBuilder setStatus(TarefasStatusEnum status) {
			this.status = status;
			return this;
		}
		public ObterTarefasResponseBuilder setTitulo (String titulo) {
			this.titulo = titulo;
			return this;
		}
		public ObterTarefasResponseBuilder setDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		public ObterTarefasResponseBuilder setResponsavel (Usuario responsavel) {
			this.responsavel = responsavel ;
			return this;
		}
		public ObterTarefasResponseBuilder setCriador (Usuario criador) {
			this.criador = criador;
			return this;
		}
	
		public ObterTarefasResponse build() {
			return new ObterTarefasResponse(this);
		}
		
	}
	
}
