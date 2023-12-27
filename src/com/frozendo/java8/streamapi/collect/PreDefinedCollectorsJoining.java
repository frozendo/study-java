package com.frozendo.java8.streamapi.collect;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PreDefinedCollectorsJoining {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        String result = products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(","));

        System.out.println("joining result = " + result);
    }

}
