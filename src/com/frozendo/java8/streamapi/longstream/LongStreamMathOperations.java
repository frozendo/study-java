package com.frozendo.java8.streamapi.longstream;

import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class LongStreamMathOperations {

    public static void main(String[] args) {

        long[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        longStreamCount(numbers);
        System.out.println();

        longStreamMax(numbers);
        System.out.println();

        longStreamMin(numbers);
        System.out.println();

        longStreamSum(numbers);
        System.out.println();

        longStreamAverage(numbers);
    }

    private static void longStreamCount(long[] numbers) {
        System.out.println("Filter even numbers and count");
        long count = LongStream.of(numbers)
                .filter(p -> p % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void longStreamMax(long[] numbers) {
        System.out.println("Get the highest number multiple of 3");
        OptionalLong max = LongStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .max();
        System.out.println(max.orElse(0));
    }

    private static void longStreamMin(long[] numbers) {
        System.out.println("Get the smallest number multiple of 3");
        OptionalLong min = LongStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .min();
        System.out.println(min.orElse(0));
    }

    private static void longStreamSum(long[] numbers) {
        System.out.println("Sum all numbers in the collection#");
        long sum = LongStream.of(numbers)
                .sum();
        System.out.println(sum);
    }

    private static void longStreamAverage(long[] numbers) {
        System.out.println("Calculate the average excluding the 5 first numbers in the collection");
        OptionalDouble average = LongStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));
    }

}
