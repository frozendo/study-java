package com.frozendo.java8.streamapi.stream;

import com.frozendo.entity.Product;

import java.util.List;

public class StreamMatch {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        anyMatchExample(list);
        System.out.println();
        allMatchExample(list);
        System.out.println();
        noneMatchExample(list);
    }

    private static void anyMatchExample(List<Product> list) {
        System.out.println("##### Any Match #####");

        boolean anyTrue = list.stream()
                .anyMatch(Product::isPaid);
        System.out.println("AnyMatch should be true = " + anyTrue);

        boolean anyFalse = list.stream()
                .anyMatch(product -> product.getPrice() < 10.0D);
        System.out.println("AnyMatch should be false = " + anyFalse);
    }

    private static void allMatchExample(List<Product> list) {
        System.out.println("##### All Match #####");

        boolean allTrue = list.stream()
                .allMatch(product -> product.getPrice() > 0.0D);
        System.out.println("AllMatch should be true = " + allTrue);

        boolean allFalse = list.stream()
                .allMatch(Product::isPaid);
        System.out.println("AllMatch should be false = " + allFalse);
    }

    private static void noneMatchExample(List<Product> list) {
        System.out.println("##### None Match #####");

        boolean noneTrue = list.stream()
                .noneMatch(product -> product.getName().equals("Ball"));
        System.out.println("NoneMatch should be true = " + noneTrue);

        boolean noneFalse = list.stream()
                .noneMatch(product -> product.getName().equals("Bicycle"));
        System.out.println("NoneMatch should be false = " + noneFalse);
    }

}
