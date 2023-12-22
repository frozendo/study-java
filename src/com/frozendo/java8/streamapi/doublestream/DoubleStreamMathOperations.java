package com.frozendo.java8.streamapi.doublestream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class DoubleStreamMathOperations {

    public static void main(String[] args) {
        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        doubleStreamCount(numbers);

        System.out.println();

        doubleStreamMax(numbers);

        System.out.println();

        doubleStreamMin(numbers);

        System.out.println();

        doubleStreamSum(numbers);

        System.out.println();

        doubleStreamAverage(numbers);

    }

    private static void doubleStreamCount(double[] numbers) {
        System.out.println("Filter the numbers less than 5 and count");
        long count = DoubleStream.of(numbers)
                .filter(p -> p < 5)
                .count();
        System.out.println(count);
    }

    private static void doubleStreamMax(double[] numbers) {
        System.out.println(" Get the highest number greater than 90 ");
        OptionalDouble max = DoubleStream.of(numbers)
                .filter(p -> p > 90)
                .max();
        System.out.println(max.orElse(0));
    }

    private static void doubleStreamMin(double[] numbers) {
        System.out.println("Get the smallest number greater than 90");
        OptionalDouble min = DoubleStream.of(numbers)
                .filter(p -> p > 90)
                .min();
        System.out.println(min.orElse(0));
    }

    private static void doubleStreamSum(double[] numbers) {
        System.out.println("Sum all numbers in the collection");
        double sum = DoubleStream.of(numbers)
                .sum();
        System.out.println(sum);
    }

    private static void doubleStreamAverage(double[] numbers) {
        System.out.println("Calculate the average excluding the 5 first numbers in the collection");
        OptionalDouble average = DoubleStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));
    }

}
