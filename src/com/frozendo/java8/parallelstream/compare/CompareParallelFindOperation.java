package com.frozendo.java8.parallelstream.compare;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompareParallelFindOperation {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        findFirstCompare(list);
        findAnyCompare(list);
    }

    private static void findFirstCompare(List<Integer> list) {
        Instant sequentialStart = Instant.now();
        Optional<Integer> sequential = list.stream().findFirst();
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        Optional<Integer> parallel = list.parallelStream().findFirst();
        Instant parallelEnd = Instant.now();

        System.out.println("findFirst sequential = " + sequential.get());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("findFirst parallel = " + parallel.get());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());

        System.out.println();
    }

    private static void findAnyCompare(List<Integer> list) {
        Instant sequentialStart = Instant.now();
        Optional<Integer> sequential = list.stream().findAny();
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        Optional<Integer> parallel = list.parallelStream().findAny();
        Instant parallelEnd = Instant.now();

        System.out.println("findAny sequential = " + sequential.get());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("findAny parallel = " + parallel.get());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());
    }

}
