package com.frozendo.java8.streamapi.groupcollectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByDownstreamCollectors {

    public static void main(String[] args) {
        Map<Integer, Map<String, List<Integer>>> collect = Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                .collect(
                        Collectors.groupingBy(i -> i / 10 * 10,
                                Collectors.groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD"))
                );

        System.out.println("Grouping by ten and after, evens and odds = " + collect);
        System.out.println();

        Map<Integer, Map<String, List<String>>> collectFactory = Stream.of("Java", "Spring", "Quarkus", "Log4", "JPA", "JVM", "JDK", "POI", "Lambda")
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.groupingBy(value -> value.startsWith("J") ? "TRUE" : "FALSE")
                        ));

        System.out.println("Grouping by length and start letter, using TreeMap = " + collectFactory);
    }

}
