package com.frozendo.java9.streams.dropwhile;

import java.util.List;

public class DropWhileWithOrderedList {

    public static void main(String[] args) {
        singleThread();
        System.out.println();
        System.out.println();
        multiThread();
    }

    private static void singleThread() {
        System.out.println("Single Thread");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
                .dropWhile(n -> n < 25)
                .forEach(value -> System.out.print(value + ", "));
    }

    private static void multiThread() {
        System.out.println("Multi Thread");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.parallelStream()
                .dropWhile(n -> n < 25)
                .forEach(value -> System.out.print(value + ", "));
    }

}
