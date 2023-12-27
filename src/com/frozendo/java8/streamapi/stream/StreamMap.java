package com.frozendo.java8.streamapi.stream;

import com.frozendo.entity.Product;

import java.util.List;

public class StreamMap {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        System.out.println("Map to product price - change from Stream<Product> to Stream<Double> #####");
        list.stream()
                .mapToDouble(Product::getPrice)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Map to product names - change from Stream<Product> to Stream<String> #####");
        list.stream()
                .map(Product::getName)
                .forEach(System.out::println);
    }

}
