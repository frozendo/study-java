package com.frozendo.java9.streams.streamofnullable;

import com.frozendo.entity.Product;

import java.util.stream.Stream;

public class StreamOfNullable {

    public static void main(String[] args) {
        Stream.ofNullable(Product.bladder())
                .forEach(System.out::println);
    }

}
