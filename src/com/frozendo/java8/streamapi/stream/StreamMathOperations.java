package com.frozendo.java8.streamapi.stream;

import com.frozendo.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMathOperations {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        streamCount(list);
        System.out.println();
        streamMax(list);
        System.out.println();
        streamMin(list);
    }

    private static void streamCount(List<Product> list) {
        System.out.println("Count how many products is paid");
        long count = list.stream()
                .filter(Product::isPaid)
                .count();
        System.out.println(count);
    }

    private static void streamMax(List<Product> list) {
        System.out.println("Get the product paid with bigger price");
        Optional<Product> max = list.stream()
                .filter(Product::isPaid)
                .max(Comparator.comparingDouble(Product::getPrice));
        System.out.println(max.orElse(new Product()));
    }

    private static void streamMin(List<Product> list) {
        System.out.println("Get the product with the lower price");
        Optional<Product> min = list.stream()
                .min(Comparator.comparingDouble(Product::getPrice));
        System.out.println(min.orElse(new Product()));
    }

}
