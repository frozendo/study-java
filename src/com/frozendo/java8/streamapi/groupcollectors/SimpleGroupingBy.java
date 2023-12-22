package com.frozendo.java8.streamapi.groupcollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleGroupingBy {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> collect = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(Collectors.groupingBy(
                        i -> i / 10 * 10
                ));

        System.out.println("Grouping by ten = " + collect);
    }

}
