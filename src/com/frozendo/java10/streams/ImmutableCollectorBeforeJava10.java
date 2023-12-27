package com.frozendo.java10.streams;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ImmutableCollectorBeforeJava10 {

    public static void main(String[] args) {
        System.out.println("Create unmodifiable list before Java 10");
        var list = Product.buildList();
        final List<Product> result = list.stream().
                collect(Collectors
                        .collectingAndThen(Collectors.toList(), List::copyOf));
        System.out.println("List result: " + list);

        try {
            result.add(new Product());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable list.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }
    }

}
