package com.frozendo.java9.streams.streamofnullable;

import com.frozendo.java8.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamOfNullableWithFlatMap {

    public static void main(String[] args) {
        List<Product> colors = new ArrayList<>();
        colors.add(Product.bicycle());
        colors.add(null);
        colors.add(Product.bladder());
        colors.add(Product.painting());
        colors.add(null);
        colors.add(Product.ring());

        colors.stream()
                .flatMap(value -> Stream.ofNullable(value))
                .forEach(System.out::println);
    }

}
