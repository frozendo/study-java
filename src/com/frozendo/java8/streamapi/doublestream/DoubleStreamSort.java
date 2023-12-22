package com.frozendo.java8.streamapi.doublestream;

import java.util.stream.DoubleStream;

public class DoubleStreamSort {

    public static void main(String[] args) {
        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        System.out.println("Ordering numbers");
        DoubleStream.of(numbers)
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Ordering, remove duplication and multiply by 2");
        DoubleStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Double multi = f * 2;
                    System.out.println(multi);
                });

    }

}
