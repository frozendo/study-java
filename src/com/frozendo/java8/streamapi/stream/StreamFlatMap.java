package com.frozendo.java8.streamapi.stream;

import com.frozendo.java8.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamFlatMap {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        List<Product> secondList = new ArrayList<>();
        secondList.add(new Product());
        secondList.add(new Product());

        System.out.println("Flatmap to product stream - change from Stream<List<Product>> to Stream<Product>");
        Stream.of(list, secondList)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Flatmap - change from Stream<List<Product>> to DoubleStream");
        Stream.of(list, secondList)
                .flatMapToDouble(f ->
                    f.stream()
                            .mapToDouble(Product::getPrice)
                ).forEach(System.out::println);
    }

}
