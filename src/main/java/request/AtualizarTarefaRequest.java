package request;

import com.aws.demo.Status.TarefasStatusEnum;
import com.aws.demo.entity.Usuario;

public class AtualizarTarefaRequest {
	
	private String titulo;
	private String descricao;
	private TarefasStatusEnum status;
	private Usuario responsavel ;
	private int quantidadeHorasEstimadas;
	private Integer quantidadeHorasRealizada;
	
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

	public TarefasStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TarefasStatusEnum status) {
		this.status = status;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setUsuario(Usuario responsavel) {
		this.responsavel = responsavel;
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

	private AtualizarTarefaRequest (AtualizarTarefaRequestBuilder build) {
		
	}
	
	public static class AtualizarTarefaRequestBuilder {
		private String titulo;
		private String descricao;
		private TarefasStatusEnum status;
		private Usuario responsavel ;
		private int quantidadeHorasEstimadas;
		private Integer quantidadeHorasRealizada;
		
		public AtualizarTarefaRequestBuilder setTitulo (String titulo) {
			this.titulo = titulo;
			return this;
		}
		public AtualizarTarefaRequestBuilder setDescricao (String descricao) {
			this.descricao = descricao;
			return this;
		}
		public AtualizarTarefaRequestBuilder setStatus (TarefasStatusEnum status) {
			this.status = status;
			return this;
		}
		public AtualizarTarefaRequestBuilder setUsuario (Usuario responsavel) {
			this.responsavel = responsavel;
			return this;
		}
		public AtualizarTarefaRequestBuilder setQuantidadeHorasEstimadas (int quantidadeHorasEstimadas) {
			this.quantidadeHorasEstimadas = quantidadeHorasEstimadas;
			return this;
		}
		public AtualizarTarefaRequestBuilder setQuantidadeHorasRealizada (int quantidadeHorasRealizada) {
			this.quantidadeHorasRealizada = quantidadeHorasRealizada;
			return this;
		}
	
	}
}
