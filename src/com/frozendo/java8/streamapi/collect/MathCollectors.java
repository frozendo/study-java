package com.frozendo.java8.streamapi.collect;

import com.frozendo.java8.entity.Product;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MathCollectors {

    public static void main(String[] args) {
        List<Product> products = Product.buildList();
        average(products);
        summing(products);
        counting(products);
        maxBy(products);
        minBy(products);
        summarizing(products);
    }

    private static void average(List<Product> products) {
        Double result = products.stream()
                .collect(Collectors.averagingDouble(
                        Product::getPrice
                ));

        System.out.println("average result = " + result);
        System.out.println();
    }

    private static void summing(List<Product> products) {
        Double result = products.stream()
                .collect(Collectors.summingDouble(
                        Product::getPrice
                ));

        System.out.println("summing result = " + result);
        System.out.println();
    }

    private static void counting(List<Product> products) {
        Long collect = products.stream()
                .collect(Collectors.counting());

        System.out.println("counting result = " + collect);
        System.out.println();
    }

    private static void maxBy(List<Product> products) {
        Optional<Product> collect = products.stream()
                .collect(Collectors.maxBy(Comparator.comparing(
                        (value) -> value.getPrice()
                )));

        System.out.println("maxBy result = " + collect.get());
        System.out.println();
    }

    private static void minBy(List<Product> products) {
        Optional<Product> collect = products.stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        (value) -> value.getPrice()
                )));

        System.out.println("minBy result = " + collect.get());
        System.out.println();
    }

    private static void summarizing(List<Product> products) {
        DoubleSummaryStatistics collect = products.stream()
                .collect(Collectors.summarizingDouble(
                        value -> value.getPrice()
                ));

        System.out.println("summarizing result = " + collect);
    }

}
