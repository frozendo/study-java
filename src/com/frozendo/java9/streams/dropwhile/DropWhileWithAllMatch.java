package com.frozendo.java9.streams.dropwhile;

import java.util.List;

public class DropWhileWithAllMatch {

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 7, 9, 15, 22, 23, 34, 47, 52, 63, 77);

        list.stream()
                .dropWhile(n -> n > 100)
                .forEach(value -> System.out.print(value + ", "));
    }

}
