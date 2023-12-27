package com.frozendo.java10.streams;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ToUnmodifiableListExample {

    public static void main(String[] args) {
        var list = Product.buildList();
        final List<String> result = list.stream()
                .map(Product::getName)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("List result: " + result);

        try {
            result.add(new Product().getName());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable list.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }
    }

}
