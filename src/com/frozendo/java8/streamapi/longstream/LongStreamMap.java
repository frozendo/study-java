package com.frozendo.java8.streamapi.longstream;

import java.util.stream.LongStream;

public class LongStreamMap {

    public static void main(String[] args) {

        long[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        System.out.println("Map transform to double");
        LongStream.of(numbers)
                .mapToDouble(Double::valueOf)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Map - multiply by 3");
        LongStream.of(numbers)
                .map(m -> m * 3)
                .forEach(System.out::println);

    }

}
