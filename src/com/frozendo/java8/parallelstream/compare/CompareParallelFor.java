package com.frozendo.java8.parallelstream.compare;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.time.Instant;

public class CompareParallelFor {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        List<Integer> resultSequential = new ArrayList<>(list.size());
        List<Integer> resultParallel = new ArrayList<>(list.size());

        Instant sequentialStart = Instant.now();
        list.stream()
                .forEach(i -> resultSequential.add(i * 2));
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        list.parallelStream()
                .forEach(i -> resultParallel.add(i * 2));
        Instant parallelEnd = Instant.now();

        System.out.println("forEach sequential = " + resultSequential.size());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("forEach parallel = " + resultParallel.size());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());

        System.out.println();

    }

}
