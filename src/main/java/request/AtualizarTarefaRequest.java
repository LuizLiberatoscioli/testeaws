package request;

import com.aws.demo.Status.TarefasStatusEnum;
import com.aws.demo.entity.Usuario;

public class AtualizarTarefaRequest {
	
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

	public void setResponsavel(Usuario responsavel) {
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

	private String titulo;
	
	private String descricao;

	private TarefasStatusEnum status;
	
	private Usuario responsavel ;
	
	private int quantidadeHorasEstimadas;
	
	private Integer quantidadeHorasRealizada;
	
	
}
