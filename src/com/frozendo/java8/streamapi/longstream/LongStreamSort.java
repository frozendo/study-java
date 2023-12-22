package com.frozendo.java8.streamapi.longstream;

import java.util.stream.LongStream;

public class LongStreamSort {

    public static void main(String[] args) {

        long[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        System.out.println("Ordering by number");
        LongStream.of(numbers)
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Ordering, remove duplication and multiply by 2");
        LongStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Long multi = f * 2;
                    System.out.println(multi);
                });

    }

}
