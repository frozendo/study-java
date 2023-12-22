package com.frozendo.java8.streamapi.intstream;

import java.util.stream.IntStream;

public class IntStreamSort {

    public static void main(String[] args) {

        int[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        System.out.println("Ordering by number");
        IntStream.of(numbers)
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Ordering, remove duplication and multiply by 2");
        IntStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Integer multi = f * 2;
                    System.out.println(multi);
                });

    }

}
