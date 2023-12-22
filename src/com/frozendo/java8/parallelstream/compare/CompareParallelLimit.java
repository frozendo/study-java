package com.frozendo.java8.parallelstream.compare;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompareParallelLimit {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        Instant sequentialStart = Instant.now();
        List<Integer> sequential = list.stream()
                .limit(10)
                .collect(Collectors.toList());
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        List<Integer> parallel = list.parallelStream()
                .limit(10)
                .collect(Collectors.toList());
        Instant parallelEnd = Instant.now();

        System.out.println("limit sequential = " + sequential);
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("limit parallel = " + parallel);
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());

    }

}
