package com.frozendo.reduction;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupCollectorsExamples {

    public static void main(String[] args) {
        GroupCollectorsExamples execute = new GroupCollectorsExamples();

        System.out.println("##### GroupingBy Examples #####");
        execute.simpleGroupingBySplitByDozens();
        execute.simpleGroupingBySplitByStringLength();
        System.out.println();

        System.out.println("##### PartitionBy Examples #####");
        execute.simplePartitionByEvenOdd();
        execute.simplePartitionByBigWords();
        System.out.println();

        System.out.println("##### Downstream collectors #####");
        execute.groupingByDownstreamCollectors();
        execute.groupingByDownstreamWithFactory();
        execute.partitionByDownstreamCollectors();
        System.out.println();
    }

    private void simpleGroupingBySplitByDozens() {
        Map<Integer, List<Integer>> collect = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(Collectors.groupingBy(
                        i -> i / 10 * 10
                ));

        System.out.println("result = " + collect);
    }

    private void simpleGroupingBySplitByStringLength() {
        Map<Integer, List<String>> collect =Stream.of("Java", "Spring", "Quarkus", "Log4", "JPA", "JVM", "JDK", "POI", "Lambda")
                .collect(Collectors.groupingBy(
                        String::length
                ));

        System.out.println("result = " + collect);
    }

    private void simplePartitionByEvenOdd() {
        Map<Boolean, List<Integer>> collect = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(Collectors.partitioningBy(
                        i -> i % 2 == 0
                ));

        System.out.println("result = " + collect);
    }

    private void simplePartitionByBigWords() {
        Map<Boolean, List<String>> collect = Stream.of("Java", "Spring", "Quarkus", "Log4", "JPA", "JVM", "JDK", "POI", "Lambda")
                .collect(Collectors.partitioningBy(
                        i -> i.length() > 5
                ));

        System.out.println("result = " + collect);
    }

    private void groupingByDownstreamCollectors() {
        Map<Integer, Map<String, List<Integer>>> collect = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(
                        Collectors.groupingBy(i -> i / 10 * 10,
                                Collectors.groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD"))
                );

        System.out.println("result = " + collect);
    }

    private void groupingByDownstreamWithFactory() {
        Map<Integer, Map<String, List<String>>> collect = Stream.of("Java", "Spring", "Quarkus", "Log4", "JPA", "JVM", "JDK", "POI", "Lambda")
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.groupingBy(value -> value.startsWith("J") ? "TRUE" : "FALSE")
                ));

        System.out.println("result = " + collect);
    }

    private void partitionByDownstreamCollectors() {
        Map<Boolean, Set<Integer>> collect = Stream.of(45, 9, 65, 77, 12, 89, 31, 12, 120, 44, 88, 120, 210, 330)
                .collect(Collectors.partitioningBy(
                        i -> i < 50,
                        Collectors.toSet())
                );

        System.out.println("result = " + collect);
    }

}
