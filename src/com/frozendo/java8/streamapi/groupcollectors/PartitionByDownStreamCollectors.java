package com.frozendo.java8.streamapi.groupcollectors;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitionByDownStreamCollectors {

    public static void main(String[] args) {
        Map<Boolean, Set<Integer>> collect = Stream.of(45, 9, 65, 77, 12, 89, 31, 12, 120, 44, 88, 120, 210, 330)
                .collect(Collectors.partitioningBy(
                        i -> i < 50,
                        Collectors.toSet())
                );

        System.out.println("Partition by less and more than 50, and collect to set = " + collect);
    }

}
