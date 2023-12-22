package com.frozendo.java8.streamapi.doublestream;

import java.util.stream.DoubleStream;

public class DoubleStreamMatch {

    public static void main(String[] args) {
        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        doubleStreamAny(numbers);

        System.out.println();

        doubleStreamAll(numbers);

        System.out.println();

        doubleStreamNone(numbers);
    }

    private static void doubleStreamAny(double[] numbers) {
        System.out.println("Any Match");

        boolean anyTrue = DoubleStream.of(numbers)
                .anyMatch(p -> p > 2);
        System.out.println("AnyMatch should be true = " + anyTrue);

        boolean anyFalse = DoubleStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);
    }

    private static void doubleStreamAll(double[] numbers) {
        System.out.println("All Match");

        boolean allTrue = DoubleStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);

        boolean allFalse = DoubleStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);
    }

    private static void doubleStreamNone(double[] numbers) {
        System.out.println("None Match");

        boolean noneTrue = DoubleStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);

        boolean noneFalse = DoubleStream.of(numbers)
                .noneMatch(p -> p > 2);
        System.out.println("NoneMatch should be false = " + noneFalse);
    }

}
