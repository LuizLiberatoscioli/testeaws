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

}