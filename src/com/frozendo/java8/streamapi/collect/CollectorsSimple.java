package com.frozendo.java8.streamapi.collect;

import com.frozendo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CollectorsSimple {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        List<String> list = products.stream()
                .collect(
                        () -> new ArrayList<>(),
                        (l, i) -> l.add(i.getName()),
                        (l1, l2) -> l1.addAll(l2)
                );

        System.out.println("list result size = " + list.size());
        System.out.println(list);
    }

}
