package com.frozendo.java8.streamapi.collect;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class PreDefinedCollectorToList {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        List<Double> list = products.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        System.out.println("list result size = " + list.size());
        System.out.println(list);
    }

}
