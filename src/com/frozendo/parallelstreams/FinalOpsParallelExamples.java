package com.frozendo.parallelstreams;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FinalOpsParallelExamples {

    public static void main(String[] args) {
        FinalOpsParallelExamples opsParallelExamples = new FinalOpsParallelExamples();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        opsParallelExamples.filterExample(list);
        opsParallelExamples.mapExample(list);
        opsParallelExamples.forEachExample(list);
    }

    public void filterExample(List<Integer> list) {
        System.out.println("##### filter #####");

        Instant sequentialStart = Instant.now();
        List<Integer> sequential = list.stream()
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        List<Integer> parallel = list.parallelStream()
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());
        Instant parallelEnd = Instant.now();

        System.out.println("filter sequential = " + sequential.size());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("filter parallel = " + parallel.size());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());

        System.out.println();
    }

    public void mapExample(List<Integer> list) {
        System.out.println("##### map #####");

        Instant sequentialStart = Instant.now();
        List<String> sequential = list.stream()
                .map(i -> i.toString())
                .collect(Collectors.toList());
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        List<String> parallel = list.parallelStream()
                .map(i -> i.toString())
                .collect(Collectors.toList());
        Instant parallelEnd = Instant.now();

        System.out.println("map sequential = " + sequential.size());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("map parallel = " + parallel.size());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());

        System.out.println();
    }

    public void forEachExample(List<Integer> list) {
        System.out.println("##### forEach #####");
        List<Integer> resultSequential = new ArrayList<>();
        List<Integer> resultParallel = new ArrayList<>();

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
