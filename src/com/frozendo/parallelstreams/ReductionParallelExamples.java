package com.frozendo.parallelstreams;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReductionParallelExamples {

    public static void main(String[] args) {
        ReductionParallelExamples execute = new ReductionParallelExamples();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        execute.reduceMethodInParallelStream(list);
        execute.collectMethodInParallelStream(list);
        execute.groupingByMethodInParallelStream(list);
    }

    private void reduceMethodInParallelStream(List<Integer> list) {
        System.out.println("##### Using reduce with parallel stream #####");
        Integer simpleIdentity = list.parallelStream()
                .reduce(0,
                        (sum, value) -> sum + value,
                        (aggr1, aggr2) -> aggr1 + aggr2);

        //each thread start with 5
        Integer biggerIdentity = list.parallelStream()
                .reduce(5,
                        (sum, value) -> sum + value,
                        (aggr1, aggr2) -> aggr1 + aggr2);

        System.out.println("reduction with identity 0 = " + simpleIdentity);
        System.out.println("reduction with identity 5 = " + biggerIdentity);

        System.out.println();
    }

    private void collectMethodInParallelStream(List<Integer> list) {
        System.out.println("##### Using collect with parallel stream #####");
        List<Integer> simpleCollect = list.parallelStream()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Integer> linkedCollect = list.parallelStream()
                .collect(LinkedList::new,
                        (container, value) -> container.add(value * 2),
                        (container1, container2) -> container1.addAll(container2));

        System.out.println("collect simple = " + simpleCollect.size());
        System.out.println("collect linked = " + linkedCollect.size());

        System.out.println();
    }

    private void groupingByMethodInParallelStream(List<Integer> list) {
        System.out.println("##### Using groupingBy with parallel stream #####");
        Instant sequentialStart = Instant.now();
        Map<Integer, List<Integer>> collectGroupingBy = list.parallelStream()
                .collect(Collectors.groupingBy(
                        i -> i / 10 * 10
                ));
        Instant sequentialEnd = Instant.now();

        Instant parallelStart = Instant.now();
        Map<Integer, List<Integer>> collectGroupingByParallel = list.parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        i -> i / 10 * 10
                ));
        Instant parallelEnd = Instant.now();

        System.out.println("groupingBy simple = " + collectGroupingBy.size());
        System.out.println("sequential duration = " + Duration.between(sequentialStart, sequentialEnd).getNano());

        System.out.println("groupingBy concurrent = " + collectGroupingByParallel.size());
        System.out.println("parallel duration = " + Duration.between(parallelStart, parallelEnd).getNano());
    }



}
