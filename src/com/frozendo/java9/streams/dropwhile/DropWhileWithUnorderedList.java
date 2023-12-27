package com.frozendo.java9.streams.dropwhile;

import java.util.List;

public class DropWhileWithUnorderedList {

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
                .unordered()
                .dropWhile(n -> n < 25)
                .forEach(value -> System.out.print(value + ", "));
    }

    private static void multiThread() {
        System.out.println("Multi Thread");
        List<Integer> list = List.of(52, 2, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.parallelStream()
                .unordered()
                .dropWhile(n -> n < 25)
                .forEach(value -> System.out.print(value + ", "));
    }

}
