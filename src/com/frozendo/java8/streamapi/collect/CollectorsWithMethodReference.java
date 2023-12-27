package com.frozendo.java8.streamapi.collect;

import com.frozendo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CollectorsWithMethodReference {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        List<String> list = products.stream()
                .collect(
                        ArrayList::new,
                        (l, i) -> l.add(i.getName()),
                        ArrayList::addAll
                );

        System.out.println("list result size = " + list.size());
        System.out.println(list);
    }

}
