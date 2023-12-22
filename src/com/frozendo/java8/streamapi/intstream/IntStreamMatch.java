package com.frozendo.java8.streamapi.intstream;

import java.util.stream.IntStream;

public class IntStreamMatch {

    public static void main(String[] args) {
        int[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        intStreamAny(numbers);
        System.out.println();
        intStreamAll(numbers);
        System.out.println();
        intStreamNone(numbers);
    }

    private static void intStreamAny(int[] numbers) {
        System.out.println("Any Match");

        boolean anyTrue = IntStream.of(numbers)
                .anyMatch(p -> p % 2 == 0);
        System.out.println("AnyMatch should be true = " + anyTrue);

        boolean anyFalse = IntStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);
    }

    private static void intStreamAll(int[] numbers) {
        System.out.println("All Match");

        boolean allTrue = IntStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);

        boolean allFalse = IntStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);
    }

    private static void intStreamNone(int[] numbers) {
        System.out.println("None Match");

        boolean noneTrue = IntStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);

        boolean noneFalse = IntStream.of(numbers)
                .noneMatch(p -> p % 2 == 0);
        System.out.println("NoneMatch should be false = " + noneFalse);
    }

}
