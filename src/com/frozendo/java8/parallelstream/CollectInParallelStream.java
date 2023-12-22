package com.frozendo.java8.parallelstream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectInParallelStream {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

        List<Integer> simpleCollect = list.parallelStream()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Integer> linkedCollect = list.parallelStream()
                .collect(LinkedList::new,
                        (container, value) -> container.add(value * 2),
                        (container1, container2) -> container1.addAll(container2));

        System.out.println("collect simple = " + simpleCollect.size());
        System.out.println("collect linked = " + linkedCollect.size());
    }

}
