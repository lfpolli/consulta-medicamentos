package br.com.enciclopedia.entity;

public class Generico {
	private String principioAtivo;
	private String medicamentoReferencia;
	private String formaFarmaceutica;
	private String concentracao;
	private String detentorRegistro;
	private String dataPublicacaoRegistro;

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getMedicamentoReferencia() {
		return medicamentoReferencia;
	}

	public void setMedicamentoReferencia(String medicamentoReferencia) {
		this.medicamentoReferencia = medicamentoReferencia;
	}

	public String getFormaFarmaceutica() {
		return formaFarmaceutica;
	}

	public void setFormaFarmaceutica(String formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}

	public String getDetentorRegistro() {
		return detentorRegistro;
	}

	public void setDetentorRegistro(String detentorRegistro) {
		this.detentorRegistro = detentorRegistro;
	}

	public String getConcentracao() {
		return concentracao;
	}

	public void setConcentracao(String concentracao) {
		this.concentracao = concentracao;
	}

	public String getDataPublicacaoRegistro() {
		return dataPublicacaoRegistro;
	}

	public void setDataPublicacaoRegistro(String dataPublicacaoRegistro) {
		this.dataPublicacaoRegistro = dataPublicacaoRegistro;
	}
}
