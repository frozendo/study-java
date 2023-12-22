package com.frozendo.java8.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateParallelStream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.print("create from a collection = ");
        list.parallelStream().forEach(System.out::print);

        System.out.println();
        System.out.println();

        System.out.print("create from a Stream of = ");
        Stream.of(99,98,97,96,95,94,93,92,91)
                .parallel()
                .forEach(System.out::print);

        System.out.println();
    }
}
