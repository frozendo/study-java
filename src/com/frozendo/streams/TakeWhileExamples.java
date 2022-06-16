package com.frozendo.streams;

import java.util.List;

public class TakeWhileExamples {

    public static void main(String[] args) {
        TakeWhileExamples execute = new TakeWhileExamples();
        execute.withAllMatchElements();
        execute.withNoneMatchElements();
        execute.withOrderedListAndSingleThread();
        execute.withOrderedListAndParallel();
        execute.withUnorderedListAndSingleThread();
        execute.withUnorderedListAndParallel();
    }

    private void withAllMatchElements() {
        System.out.println("##### All Matches Elements #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
            .takeWhile(n -> n < 100)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    private void withNoneMatchElements() {
        System.out.println("##### None matches elements #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
            .takeWhile(n -> n > 100)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    private void withOrderedListAndSingleThread() {
        System.out.println("##### Ordered List with Single Thread #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
            .takeWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    private void withOrderedListAndParallel() {
        System.out.println("##### Ordered List with Parallel #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.parallelStream()
            .takeWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    private void withUnorderedListAndSingleThread() {
        System.out.println("##### Unordered List with Single Thread #####");
        List<Integer> list = List.of(2, 52, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.stream()
            .unordered()
            .takeWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    private void withUnorderedListAndParallel() {
        System.out.println("##### Unordered List with Parallel #####");
        List<Integer> list = List.of(52, 2, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.parallelStream()
            .unordered()
            .takeWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

}