package com.frozendo.java8.streamapi.longstream;

import java.util.OptionalLong;
import java.util.stream.LongStream;

public class LongStreamFilterAndFind {

    public static void main(String[] args) {

        long[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        System.out.println("Filter numbers less than 50 and get first");
        OptionalLong first = LongStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("Filter numbers more than 80 and get any");
        OptionalLong any = LongStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));

    }

}
