package com.frozendo.java9.streams.takewhile;

import java.util.List;

public class TakeWhileWithUnorderedList {

    public static void main(String[] args) {
        singleThread();
        System.out.println();
        System.out.println();
        multiThread();
    }

    private static void singleThread() {
        System.out.println("Single Thread");
        List<Integer> list = List.of(2, 52, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.stream()
                .takeWhile(n -> n < 25)
                .forEach(value -> System.out.print(value + ", "));
    }

    private static void multiThread() {
        System.out.println("Multi Thread");
        List<Integer> list = List.of(52, 2, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.parallelStream()
                .takeWhile(n -> n < 25)
                .forEach(value -> System.out.print(value + ", "));
    }

}
