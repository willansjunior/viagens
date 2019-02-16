package br.com.viagens.model;

import java.math.BigDecimal;

/**
 * Created by willans on 15/02/19.
 */
public class Pacote {

    private String cidade;
    private String imagem;
    private String dias;
    private BigDecimal preco;

    public Pacote(String são_paulo, String sao_paulo_sp, int i, BigDecimal preco) {
        this.cidade = cidade;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
