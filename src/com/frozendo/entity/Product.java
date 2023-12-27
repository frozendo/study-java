package com.frozendo.entity;

import java.util.Arrays;
import java.util.List;

public class Product {

    public Product() {
        this(1L, "Default Product", 10D, false);
    }

    public Product(Long id, String name) {
        this(id, name, 10D, false);
    }

    public Product(Long id, String name, Double price, boolean isPaid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isPaid = isPaid;
    }

    private final Long id;
    private final String name;
    private final Double price;
    private final boolean isPaid;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isPaid=" + isPaid +
                '}';
    }

    public static List<Product> buildList() {
        return Arrays.asList(bladder(), ring(), bicycle(), painting());
    }

    public static Product bladder() {
        return new Product(1L, "Bladder", 22.20D, false);
    }

    public static Product ring() {
        return new Product(2L, "Ring", 32.40D, true);
    }

    public static Product bicycle() {
        return new Product(3L, "Bicycle", 320.10D, false);
    }

    public static Product painting() {
        return new Product(4L, "Painting", 279.99D, true);
    }
}
