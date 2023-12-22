package com.frozendo.java8.streamapi.doublestream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class DoubleStreamFilterAndFind {

    public static void main(String[] args) {
        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        System.out.println("Filter numbers less than 50 and get first");
        OptionalDouble first = DoubleStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("Filter numbers more than 80 and get any");
        OptionalDouble any = DoubleStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));
    }

}
