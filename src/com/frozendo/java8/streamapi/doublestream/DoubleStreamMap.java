package com.frozendo.java8.streamapi.doublestream;

import java.util.stream.DoubleStream;

public class DoubleStreamMap {

    public static void main(String[] args) {
        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        System.out.println("Map transform to int");
        DoubleStream.of(numbers)
                .mapToInt(m -> Double.valueOf(m).intValue())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Map - multiply by 3");
        DoubleStream.of(numbers)
                .map(m -> m * 3)
                .forEach(System.out::println);

    }

}
