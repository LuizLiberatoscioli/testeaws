package request;

public class CadastrarTarefaRequest {

	private String titulo;
	private String descricao;
	private Long criadorId;
	private int quantidadeHorasEstimadas;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCriadorId() {
		return criadorId;
	}

	public void setCriadorId(Long criadorId) {
		this.criadorId = criadorId;
	}

	public int getQuantidadeHorasEstimadas() {
		return quantidadeHorasEstimadas;
	}

	public void setQuantidadeHorasEstimadas(int quantidadeHorasEstimadas) {
		this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
	}
	
	private CadastrarTarefaRequest (CadastrarTarefaRequestBuilder builder) {
		this.titulo = builder.titulo;
		this.criadorId = builder.criadorId;
		this.descricao = builder.descricao;
		this.quantidadeHorasEstimadas = builder.quantidadeHorasEstimadas;
	}
	
	public static class CadastrarTarefaRequestBuilder {
		private String titulo;
		private String descricao;
		private Long criadorId;
		private int quantidadeHorasEstimadas;
		
		
		public CadastrarTarefaRequestBuilder setTitulo (String titulo) {
			this.titulo = titulo;
			return this;
		}
		public CadastrarTarefaRequestBuilder setDescricao (String descricao) {
			this.descricao = descricao;
			return this;
		}
		public CadastrarTarefaRequestBuilder setCriadorId (Long criadorId) {
			this.criadorId = criadorId;
			return this;
		}
		public CadastrarTarefaRequestBuilder setQuantidade (int quantidadeHorasEstimadas) {
			this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
			return this;
		}
		
		public CadastrarTarefaRequest build() {
			return new CadastrarTarefaRequest (this);
		}

	}

}