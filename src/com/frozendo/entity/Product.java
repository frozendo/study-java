package com.frozendo.entity;

import java.util.Arrays;
import java.util.List;

public class Product {

    public Product() {
        this(1L, "Construtor Padrão", 10D);
    }

    public Product(Long id, String nome, Double preco) {
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

    public static List<Product> buildList() {
        Product product1 = new Product(1L, "Dado", 22.20D);
        Product product2 = new Product(2L, "Cabide", 32.40D);
        Product product3 = new Product(3L, "Bexiga", 12.10D);
        Product product4 = new Product(4L, "Anel", 58.20D);
        return Arrays.asList(product1, product2, product3, product4);
    }
}
