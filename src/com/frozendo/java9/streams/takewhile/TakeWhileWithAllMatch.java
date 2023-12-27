package com.frozendo.java9.streams.takewhile;

import java.util.List;

public class TakeWhileWithAllMatch {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
                .takeWhile(n -> n < 100)
                .forEach(value -> System.out.print(value + ", "));
    }

}
