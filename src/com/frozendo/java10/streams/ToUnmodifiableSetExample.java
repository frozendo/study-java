package com.frozendo.java10.streams;

import com.frozendo.entity.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class ToUnmodifiableSetExample {

    public static void main(String[] args) {
        var list = Product.buildList();
        final Set<String> result = list.stream()
                .map(Product::getName)
                .collect(Collectors.toUnmodifiableSet());
        System.out.println("List result: " + result);

        try {
            result.add(new Product().getName());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable set.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }
    }

}
