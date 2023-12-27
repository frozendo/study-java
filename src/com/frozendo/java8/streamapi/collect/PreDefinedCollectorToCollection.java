package com.frozendo.java8.streamapi.collect;

import com.frozendo.entity.Product;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PreDefinedCollectorToCollection {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        Set<String> set = products.stream()
                .map(Product::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("set result size = " + set.size());
        System.out.println(set);

        List<Double> list = products.stream()
                .map(Product::getPrice)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("list result size = " + list.size());
        System.out.println(list);
    }

}
