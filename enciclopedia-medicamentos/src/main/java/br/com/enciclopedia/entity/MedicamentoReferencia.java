package br.com.enciclopedia.entity;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoReferencia {
    private String principioAtivo;
    private String nomeMedicamento;
    private String formaFarmaceutica;
    private String concentracao;
    private String detentorRegistro;
    private String dataInclusaoRegistro;
    private String numeroRegistro;
    private List<Generico> genericos = new ArrayList<Generico>();
    private List<Similar> similares = new ArrayList<Similar>();

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String medicamentoReferencia) {
        this.nomeMedicamento = medicamentoReferencia;
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

    public String getDataInclusaoRegistro() {
        return dataInclusaoRegistro;
    }

    public void setDataInclusaoRegistro(String dataPublicacaoRegistro) {
        this.dataInclusaoRegistro = dataPublicacaoRegistro;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public List<Generico> getGenericos() {
        return genericos;
    }

    public void setGenericos(List<Generico> genericos) {
        this.genericos = genericos;
    }

    public List<Similar> getSimilares() {
        return similares;
    }

    public void setSimilares(List<Similar> similares) {
        this.similares = similares;
    }

    @Override
    public String toString() {
        return this.getNomeMedicamento() + " - " + this.getPrincipioAtivo() + " - " + this.getFormaFarmaceutica() + " - "
                + this.getConcentracao() + " - " + this.getDetentorRegistro();
    }

}
