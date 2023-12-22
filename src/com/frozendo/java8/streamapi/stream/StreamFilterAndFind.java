package com.frozendo.java8.streamapi.stream;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.Optional;

public class StreamFilterAndFind {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        System.out.println("Filter products that is paid and get first");
        Optional<Product> first = list.stream()
                .filter(Product::isPaid)
                .findFirst();
        System.out.println(
                first.orElse(new Product())
        );

        System.out.println();

        System.out.println("Filter products with price bigger than 100,00 and find any");
        Optional<Product> any = list.stream()
                .filter(product -> product.getPrice() > 100.0D)
                .findAny();
        System.out.println(any.orElse(new Product()));
    }

}
