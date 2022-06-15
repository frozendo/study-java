package com.frozendo.javastream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamExamples {

    public static void main(String[] args) {

        IntStreamExamples execute = new IntStreamExamples();

        int[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        execute.sortAndPrint(numbers);
        execute.filterAndFind(numbers);
        execute.matchExamples(numbers);
        execute.collectionCalculate(numbers);
        execute.mapExample(numbers);

    }

    private void sortAndPrint(int[] numbers) {
        System.out.println("##### Ordering and limit in 5 items #####");
        IntStream.of(numbers)
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Ordering, remove duplication and multiply by 2 #####");
        IntStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Integer multi = f * 2;
                    System.out.println(multi);
                });

        System.out.println();
    }

    private void filterAndFind(int[] numbers) {
        System.out.println("##### Filter numbers less than 50 and get the first #####");
        OptionalInt first = IntStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("##### Filter numbers more than 80 and get the any #####");
        OptionalInt any = IntStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));

        System.out.println();
    }

    private void matchExamples(int[] numbers) {
        System.out.println("##### Any Match #####");
        boolean anyTrue = IntStream.of(numbers)
                .anyMatch(p -> p % 2 == 0);
        System.out.println("AnyMatch should be true = " + anyTrue);
        boolean anyFalse = IntStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);

        System.out.println();

        System.out.println("##### All Match #####");
        boolean allTrue = IntStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);
        boolean allFalse = IntStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);

        System.out.println();

        System.out.println("##### None Match #####");
        boolean noneTrue = IntStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);
        boolean noneFalse = IntStream.of(numbers)
                .noneMatch(p -> p % 2 == 0);
        System.out.println("NoneMatch should be false = " + noneFalse);

        System.out.println();
    }

    private void collectionCalculate(int[] numbers) {
        System.out.println("##### Filter the numbers multiple of 2 and count #####");
        long count = IntStream.of(numbers)
                .filter(p -> p % 2 == 0)
                .count();
        System.out.println(count);

        System.out.println();

        System.out.println("#####  Get the highest number multiple of 3  #####");
        OptionalInt max = IntStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .max();
        System.out.println(max.orElse(0));

        System.out.println();

        System.out.println("##### Get the smallest number multiple of 3 #####");
        OptionalInt min = IntStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .min();
        System.out.println(min.orElse(0));

        System.out.println();

        System.out.println("##### Sum all numbers in the collection #####");
        int sum = IntStream.of(numbers)
                .sum();
        System.out.println(sum);

        System.out.println();

        System.out.println("##### Calculate the average excluding the 5 first numbers in the collection #####");
        OptionalDouble average = IntStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));

        System.out.println();
    }

    private void mapExample(int[] numbers) {
        System.out.println("##### Map transform to long #####");
        IntStream.of(numbers)
                .mapToLong(Long::valueOf)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Map - multiply by 3 #####");
        IntStream.of(numbers)
                .map(m -> m * 3)
                .forEach(System.out::println);

        System.out.println();

    }
}
