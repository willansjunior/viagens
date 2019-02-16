package br.com.viagens.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by willans on 15/02/19.
 */
public class Pacote implements Serializable {

    private String cidade;
    private String imagem;
    private int dias;
    private BigDecimal preco;

    public Pacote(String cidade, String imagem, int dias, BigDecimal preco) {
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

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
