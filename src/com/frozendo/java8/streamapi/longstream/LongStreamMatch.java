package com.frozendo.java8.streamapi.longstream;

import java.util.stream.LongStream;

public class LongStreamMatch {

    public static void main(String[] args) {
        long[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        longStreamAny(numbers);
        System.out.println();
        longStreamAll(numbers);
        System.out.println();
        longStreamNone(numbers);
    }

    private static void longStreamAny(long[] numbers) {
        System.out.println("Any Match");

        boolean anyTrue = LongStream.of(numbers)
                .anyMatch(p -> p % 2 == 0);
        System.out.println("AnyMatch should be true = " + anyTrue);

        boolean anyFalse = LongStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);
    }

    private static void longStreamAll(long[] numbers) {
        System.out.println("All Match");

        boolean allTrue = LongStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);

        boolean allFalse = LongStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);
    }

    private static void longStreamNone(long[] numbers) {
        System.out.println("None Match");

        boolean noneTrue = LongStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);

        boolean noneFalse = LongStream.of(numbers)
                .noneMatch(p -> p % 2 == 0);
        System.out.println("NoneMatch should be false = " + noneFalse);
    }

}
