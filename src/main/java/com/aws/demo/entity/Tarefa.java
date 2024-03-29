package com.aws.demo.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.aws.demo.Status.TarefasStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefas")
public class Tarefa implements Serializable{

	@Override
	public int hashCode() {
		return Objects.hash(criador, dataAtualizacao, dataCadastro, descricao, id, quantidadeHorasEstimadas,
				quantidadeHorasRealizada, responsavel, status, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(criador, other.criador) && Objects.equals(dataAtualizacao, other.dataAtualizacao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && quantidadeHorasEstimadas == other.quantidadeHorasEstimadas
				&& Objects.equals(quantidadeHorasRealizada, other.quantidadeHorasRealizada)
				&& Objects.equals(responsavel, other.responsavel) && status == other.status
				&& Objects.equals(titulo, other.titulo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Tarefa() {
		
	}

	public Tarefa(Long id, String titulo, String descricao, TarefasStatusEnum status, Usuario responsavel,
			Usuario criador, int quantidadeHorasEstimadas, Integer quantidadeHorasRealizada, LocalTime dataCadastro,
			LocalTime dataAtualizacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.responsavel = responsavel;
		this.criador = criador;
		this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
		this.quantidadeHorasRealizada = quantidadeHorasRealizada;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TarefasStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TarefasStatusEnum status) {
		this.status = status;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public int getQuantidadeHorasEstimadas() {
		return quantidadeHorasEstimadas;
	}

	public void setQuantidadeHorasEstimadas(int quantidadeHorasEstimadas) {
		this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
	}

	public Integer getQuantidadeHorasRealizada() {
		return quantidadeHorasRealizada;
	}

	public void setQuantidadeHorasRealizada(Integer quantidadeHorasRealizada) {
		this.quantidadeHorasRealizada = quantidadeHorasRealizada;
	}

	public LocalTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false )
	private String titulo;
	
	@Column(nullable = false )
	private String descricao;
	
	@Column(nullable = false )
	@Enumerated(EnumType.STRING)
	private TarefasStatusEnum status;
	
	@Column
	private Usuario responsavel ;
	
	@Column(nullable = false )
	private Usuario criador ;
	
	@Column(nullable = false )
	private int quantidadeHorasEstimadas;
	
	@Column
	private Integer quantidadeHorasRealizada;
	
	@Column
	@CreationTimestamp 
	private LocalTime dataCadastro ;
	
	@Column
	@UpdateTimestamp
	private LocalTime dataAtualizacao;
	
	
	private Tarefa(TarefaBuilder builder) {
		this.quantidadeHorasEstimadas = builder.quantidadeHorasEstimadas;
		this.status = builder.status;
		this.titulo = builder.titulo;
		this.descricao = builder.descricao;
		this.responsavel = builder.responsavel;
		this.criador = builder.criador;
	}
	
	public static class TarefaBuilder {
		private int quantidadeHorasEstimadas;
		private TarefasStatusEnum status;
		private String titulo;
		private String descricao;
		private Usuario responsavel;
		private Usuario criador;
		
		public TarefaBuilder setQuantidadeHorasEstimadas(int quantidadeHorasEstimadas) {
			this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
			return this;
		}
		
		public TarefaBuilder setStatus(TarefasStatusEnum status) {
			this.status = status;
			return this;
		}
		public TarefaBuilder setTitulo (String titulo) {
			this.titulo = titulo;
			return this;
		}
		public TarefaBuilder setDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		public TarefaBuilder setResponsavel (Usuario responsavel) {
			this.responsavel = responsavel ;
			return this;
		}
		public TarefaBuilder setCriador (Usuario criador) {
			this.criador = criador;
			return this;
		}
	
		public Tarefa build() {
			return new Tarefa(this);
		}
		
	}
	

}
