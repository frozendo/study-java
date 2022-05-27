package com.frozendo.streams;

import java.util.List;

public class DropWhileExamples {

    public static void main(String[] args) {
        DropWhileExamples execute = new DropWhileExamples();
        execute.withAllMatchElements();
        execute.withNoneMatchElements();
        execute.withOrderedListAndSingleThread();
        execute.withOrderedListAndParallel();
        execute.withUnorderedListAndSingleThread();
        execute.withUnorderedListAndParallel();
    }

    public void withAllMatchElements() {
        System.out.println("##### All Matches Elements #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
            .dropWhile(n -> n > 100)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    public void withNoneMatchElements() {
        System.out.println("##### None matches elements #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
            .dropWhile(n -> n < 100)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    public void withOrderedListAndSingleThread() {
        System.out.println("##### Ordered List with Single Thread #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
            .dropWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    public void withOrderedListAndParallel() {
        System.out.println("##### Ordered List with Parallel #####");
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.parallelStream()
            .dropWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    public void withUnorderedListAndSingleThread() {
        System.out.println("##### Unordered List with Single Thread #####");
        List<Integer> list = List.of(2, 52, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.stream()
            .unordered()
            .dropWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

    public void withUnorderedListAndParallel() {
        System.out.println("##### Unordered List with Parallel #####");
        List<Integer> list = List.of(52, 2, 7, 22, 47, 63, 23, 34, 15, 9, 77);

        list.parallelStream()
            .unordered()
            .dropWhile(n -> n < 25)
            .forEach(value -> System.out.print(value + ", "));

        System.out.println();
    }

}