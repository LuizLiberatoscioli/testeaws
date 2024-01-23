package request;

import com.aws.demo.Status.TarefasStatusEnum;

public class CadastrarTarefaRequest {

	private String titulo;

	private String descricao;

	private TarefasStatusEnum status;

	private Long responsavelId;

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

	public TarefasStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TarefasStatusEnum status) {
		this.status = status;
	}

	public Long getResponsavelId() {
		return responsavelId;
	}

	public void setResponsavelId(Long responsavelId) {
		this.responsavelId = responsavelId;
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

}