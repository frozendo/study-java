package com.frozendo.java8.parallelstream;

import java.util.ArrayList;
import java.util.List;

public class ReduceInParallelStream {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }

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
    }

}
