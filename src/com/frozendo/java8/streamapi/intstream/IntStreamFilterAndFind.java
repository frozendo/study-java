package com.frozendo.java8.streamapi.intstream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamFilterAndFind {

    public static void main(String[] args) {
        int[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        System.out.println("Filter numbers less than 50 and get first");
        OptionalInt first = IntStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("Filter numbers more than 80 and get any");
        OptionalInt any = IntStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));
    }
}
