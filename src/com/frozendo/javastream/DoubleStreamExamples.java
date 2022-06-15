package com.frozendo.javastream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class DoubleStreamExamples {

    public static void main(String[] args) {

        DoubleStreamExamples execute = new DoubleStreamExamples();

        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        execute.sortAndPrint(numbers);
        execute.filterAndFind(numbers);
        execute.matchExamples(numbers);
        execute.collectionCalculate(numbers);
        execute.mapExample(numbers);

    }

    private void sortAndPrint(double[] numbers) {
        System.out.println("##### Ordering and limit in 5 items #####");
        DoubleStream.of(numbers)
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Ordering, remove duplication and multiply by 2 #####");
        DoubleStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Double multi = f * 2;
                    System.out.println(multi);
                });

        System.out.println();
    }

    private void filterAndFind(double[] numbers) {
        System.out.println("##### Filter numbers less than 50 and get the first #####");
        OptionalDouble first = DoubleStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("##### Filter numbers more than 50 and get the any #####");
        OptionalDouble any = DoubleStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));

        System.out.println();
    }

    private void matchExamples(double[] numbers) {
        System.out.println("##### Any Match #####");
        boolean anyTrue = DoubleStream.of(numbers)
                .anyMatch(p -> p > 2);
        System.out.println("AnyMatch should be true = " + anyTrue);
        boolean anyFalse = DoubleStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);

        System.out.println();

        System.out.println("##### All Match #####");
        boolean allTrue = DoubleStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);
        boolean allFalse = DoubleStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);

        System.out.println();

        System.out.println("##### None Match #####");
        boolean noneTrue = DoubleStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);
        boolean noneFalse = DoubleStream.of(numbers)
                .noneMatch(p -> p > 2);
        System.out.println("NoneMatch should be false = " + noneFalse);

        System.out.println();
    }

    private void collectionCalculate(double[] numbers) {
        System.out.println("##### Filter the numbers less than 5 and count #####");
        long count = DoubleStream.of(numbers)
                .filter(p -> p < 5)
                .count();
        System.out.println(count);

        System.out.println();

        System.out.println("#####  Get the highest number greater than 90  #####");
        OptionalDouble max = DoubleStream.of(numbers)
                .filter(p -> p > 90)
                .max();
        System.out.println(max.orElse(0));

        System.out.println();

        System.out.println("##### Get the smallest number greater than 90 #####");
        OptionalDouble min = DoubleStream.of(numbers)
                .filter(p -> p > 90)
                .min();
        System.out.println(min.orElse(0));

        System.out.println();

        System.out.println("##### Sum all numbers in the collection #####");
        double sum = DoubleStream.of(numbers)
                .sum();
        System.out.println(sum);

        System.out.println();

        System.out.println("##### Calculate the average excluding the 5 first numbers in the collection #####");
        OptionalDouble average = DoubleStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));

        System.out.println();
    }

    private void mapExample(double[] numbers) {
        System.out.println("##### Map transform to int #####");
        DoubleStream.of(numbers)
                .mapToInt(m -> Double.valueOf(m).intValue())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Map - multiply by 3 #####");
        DoubleStream.of(numbers)
                .map(m -> m * 3)
                .forEach(System.out::println);

        System.out.println();

    }
}
