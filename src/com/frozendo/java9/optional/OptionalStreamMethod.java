package com.frozendo.java9.optional;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalStreamMethod {

    public static void main(String[] args) {
        System.out.println("Basic use");
        Optional<Product> oldDate = Optional.of(Product.bicycle());
        final List<Product> collect = oldDate.stream()
                .collect(Collectors.toList());
        System.out.println("Optional value in a list: " + collect);

        System.out.println();

        System.out.println("Use with Stream<Optional> list");
        Stream<OptionalInt> values = Stream.of(OptionalInt.of(10), OptionalInt.of(20),
                OptionalInt.of(30), OptionalInt.of(40));

        final int sum = values.flatMapToInt(OptionalInt::stream).sum();
        System.out.println("Optional values sum: " + sum);
    }

}
