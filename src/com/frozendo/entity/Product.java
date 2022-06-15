package com.frozendo.entity;

import java.util.Arrays;
import java.util.List;

public class Product {

    public Product() {
        this(1L, "Default Product", 10D);
    }

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private final Long id;
    private final String name;
    private final Double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static List<Product> buildList() {
        Product product1 = new Product(1L, "Bladder", 22.20D);
        Product product2 = new Product(2L, "Ring", 32.40D);
        Product product3 = new Product(3L, "Bicycle", 320.10D);
        Product product4 = new Product(4L, "Painting", 279.99D);
        return Arrays.asList(product1, product2, product3, product4);
    }
}
