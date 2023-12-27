package com.frozendo.java9.streams.iterate;

import java.util.stream.Stream;

public class IterateUntilJava8 {

    public static void main(String[] args) {
        usingLimitToStopIterate();
        System.out.println();
        generateFibonacci();
    }

    private static void usingLimitToStopIterate() {
        System.out.println("Using limit to stop iterate from java 8");

        Stream.iterate(1, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void generateFibonacci() {
        System.out.println("Generate Fibonacci with java 8 version");

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(System.out::println);

        System.out.println();
    }

}
