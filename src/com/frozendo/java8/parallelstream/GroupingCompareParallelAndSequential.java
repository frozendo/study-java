package com.frozendo.java8.parallelstream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingCompareParallelAndSequential {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        sequentialExecution(list);
        parallelExecution(list);
    }

    private static void sequentialExecution(List<Integer> list) {
        Instant sequentialStart = Instant.now();
        Map<Integer, List<Integer>> collectGroupingBy = list.parallelStream()
                .collect(Collectors.groupingBy(
                        i -> i / 10 * 10
                ));
        Instant sequentialEnd = Instant.now();

        System.out.println("groupingBy simple = " + collectGroupingBy.size());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());
        System.out.println();
    }

    private static void parallelExecution(List<Integer> list) {
        Instant parallelStart = Instant.now();
        Map<Integer, List<Integer>> collectGroupingByParallel = list.parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        i -> i / 10 * 10
                ));
        Instant parallelEnd = Instant.now();

        System.out.println("groupingBy concurrent = " + collectGroupingByParallel.size());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());
    }

}
