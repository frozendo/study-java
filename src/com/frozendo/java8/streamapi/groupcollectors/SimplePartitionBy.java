package com.frozendo.java8.streamapi.groupcollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplePartitionBy {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(Collectors.partitioningBy(
                        i -> i % 2 == 0
                ));

        System.out.println("Partition by evens and odds = " + collect);
    }

}
