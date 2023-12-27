package com.frozendo.java8.streamapi.collect;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PreDefinedCollectorToSet {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        Set<String> set = products.stream()
                .map(Product::getName)
                .collect(Collectors.toSet());

        System.out.println("set result size = " + set.size());
        System.out.println(set);
    }

}
