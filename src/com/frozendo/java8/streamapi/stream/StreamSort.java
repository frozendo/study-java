package com.frozendo.java8.streamapi.stream;

import com.frozendo.java8.entity.Product;

import java.util.List;

public class StreamSort {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        System.out.println("Ordering products in alphabetic order");
        list.stream()
                .map(Product::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println();


        System.out.println("Ordering products by price in reverse order");
        list.stream()
                .sorted((p1, p2) -> (int) (p2.getPrice() - p1.getPrice()))
                .forEach(System.out::println);
    }

}
