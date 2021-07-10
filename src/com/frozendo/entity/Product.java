package com.frozendo.lambda.entity;

import java.util.Arrays;
import java.util.List;

public class Produto {

    public Produto() {
        this(1L, "Construtor Padrão", 10D);
    }

    public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    private Long id;
    private String nome;
    private Double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public static List<Produto> buildList() {
        Produto produto1 = new Produto(1L, "Dado", 22.20D);
        Produto produto2 = new Produto(2L, "Cabide", 32.40D);
        Produto produto3 = new Produto(3L, "Bexiga", 12.10D);
        Produto produto4 = new Produto(4L, "Anel", 58.20D);
        return Arrays.asList(produto1, produto2, produto3, produto4);
    }
}
