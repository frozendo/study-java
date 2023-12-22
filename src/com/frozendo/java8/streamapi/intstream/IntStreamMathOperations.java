package com.frozendo.java8.streamapi.intstream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamMathOperations {

    public static void main(String[] args) {

        int[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        intStreamCount(numbers);
        System.out.println();

        intStreamMax(numbers);
        System.out.println();

        intStreamMin(numbers);
        System.out.println();

        intStreamSum(numbers);
        System.out.println();

        intStreamAverage(numbers);
    }

    private static void intStreamCount(int[] numbers) {
        System.out.println("Filter even numbers and count");
        long count = IntStream.of(numbers)
                .filter(p -> p % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void intStreamMax(int[] numbers) {
        System.out.println("Get the highest number multiple of 3");
        OptionalInt max = IntStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .max();
        System.out.println(max.orElse(0));
    }

    private static void intStreamMin(int[] numbers) {
        System.out.println("Get the smallest number multiple of 3");
        OptionalInt min = IntStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .min();
        System.out.println(min.orElse(0));
    }

    private static void intStreamSum(int[] numbers) {
        System.out.println("Sum all numbers in the collection#");
        int sum = IntStream.of(numbers)
                .sum();
        System.out.println(sum);
    }

    private static void intStreamAverage(int[] numbers) {
        System.out.println("Calculate the average excluding the 5 first numbers in the collection");
        OptionalDouble average = IntStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));
    }

}
