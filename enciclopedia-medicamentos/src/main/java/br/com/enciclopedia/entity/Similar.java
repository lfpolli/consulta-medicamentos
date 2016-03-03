package br.com.enciclopedia.entity;

public class Similar {
    private String medicamentoReferencia;
    private String principioAtivo;
    private String nomeComercial;
    private String detentorRegistro;
    private String formaFarmaceutica;
    private String concentracao;
    private String dataInclusao;

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
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

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    @Override
    public String toString() {
        return this.getNomeComercial() + " - " + this.getPrincipioAtivo() + " - " + this.getFormaFarmaceutica() + " - "
                + this.getConcentracao() + " - " + this.getDetentorRegistro();
    }
}
