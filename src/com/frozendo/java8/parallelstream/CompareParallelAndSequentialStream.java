package com.frozendo.java8.parallelstream;

import java.util.stream.Stream;

public class CompareParallelAndSequentialStream {

    public static void main(String[] args) {
        Stream<Integer> toParallel = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .parallel();
        Stream<Integer> parallelToChange = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .parallel();
        Stream<Integer> toSequential = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("Check if the stream is parallel or sequencial");
        System.out.println("Is parallel? = " + toParallel.isParallel());
        System.out.println("Is parallel? = " + toSequential.isParallel());
        System.out.println("Is parallel? = " + parallelToChange.isParallel());
        System.out.println();

        System.out.print("Execute stream parallel = ");
        toParallel.forEach(System.out::print);
        System.out.println();

        System.out.print("Execute stream sequential = ");
        toSequential.forEach(System.out::print);
        System.out.println();

        System.out.print("Get parallel stream and execute sequential = ");
        parallelToChange.sequential().forEach(System.out::print);

        System.out.println();
    }

}
