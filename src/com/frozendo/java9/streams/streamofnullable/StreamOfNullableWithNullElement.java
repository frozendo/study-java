package com.frozendo.java9.streams.streamofnullable;

import java.util.stream.Stream;

public class StreamOfNullableWithNullElement {

    public static void main(String[] args) {
        Stream.ofNullable(null)
                .forEach(System.out::println);
        System.out.println("Nothing is printed but a NullPointException don't occur");
    }

}
