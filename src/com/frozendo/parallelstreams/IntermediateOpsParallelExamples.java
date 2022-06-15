package com.frozendo.parallelstreams;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IntermediateOpsParallelExamples {

    public static void main(String[] args) {
        IntermediateOpsParallelExamples execute = new IntermediateOpsParallelExamples();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        execute.findFirstAndCompare(list);
        execute.sortedAndCompare(list);
        execute.limitAndCompare(list);
        execute.findAnyAndCompare(list);
    }

    private void findFirstAndCompare(List<Integer> list) {
        System.out.println("##### Execute and compare findFirst in sequential and parallel stream #####");

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

    private void sortedAndCompare(List<Integer> list) {
        System.out.println("##### Execute and compare sorted in sequential and parallel stream #####");

        Instant sequentialStart = Instant.now();
        List<Integer> sequential = list.stream()
                .sorted()
                .collect(Collectors.toList());
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        List<Integer> parallel = list.parallelStream()
                .sorted()
                .collect(Collectors.toList());
        Instant parallelEnd = Instant.now();

        System.out.println("sorted sequential = " + sequential.size());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("sorted parallel = " + parallel.size());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());

        System.out.println();
    }

    private void limitAndCompare(List<Integer> list) {
        System.out.println("##### Execute and compare limit in sequential and parallel stream #####");

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

        System.out.println();
    }

    private void findAnyAndCompare(List<Integer> list) {
        System.out.println("##### Execute and compare findAny in sequential and parallel stream #####");

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

        System.out.println();
    }



}
