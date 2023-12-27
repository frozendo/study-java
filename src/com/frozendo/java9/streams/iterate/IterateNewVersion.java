package com.frozendo.java9.streams.iterate;

import java.util.stream.Stream;

public class IterateNewVersion {

    public static void main(String[] args) {
        iterateJava9Version();
        System.out.println();
        generateFibonacci();
    }

    private static void iterateJava9Version() {
        System.out.println("Using iterate from java 9");

        Stream.iterate(1,
                n -> n < 1000,
                n -> n * 2
        ).forEach(System.out::println);
    }

    private static void generateFibonacci() {
        System.out.println("Generate Fibonacci with java 9 version");

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(System.out::println);

        System.out.println();
    }

}
