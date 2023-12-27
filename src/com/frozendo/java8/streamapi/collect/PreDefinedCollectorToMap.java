package com.frozendo.java8.streamapi.collect;

import com.frozendo.entity.Product;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PreDefinedCollectorToMap {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();

        Map<Double, String> map = products.stream()
                .collect(Collectors.toMap(
                        Product::getPrice, Product::getName
                ));

        System.out.println("map result size = " + map.size());
        System.out.println(map);

        System.out.println("toMap collector - with merge function");
        Map<Long, Double> linkedHashMap = products.stream()
                .collect(Collectors.toMap(
                        Product::getId,
                        Product::getPrice,
                        (existing, replacement) -> {
                            if (existing > replacement) {
                                return existing;
                            }
                            return replacement;
                        },
                        LinkedHashMap::new
                ));

        System.out.println("linkedHashMap result size = " + linkedHashMap.size());
        System.out.println(linkedHashMap);
    }

}
