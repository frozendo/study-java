package com.frozendo.java10.streams;

import com.frozendo.entity.Product;

import java.util.Map;
import java.util.stream.Collectors;

public class ToUnmodifiableMapWithDuplicateKeys {

    public static void main(String[] args) {
        var list = Product.buildList();

        try {
            final Map<String, String> result = list.stream()
                    .map(Product::getName)
                    .collect(Collectors.toUnmodifiableMap(s -> s.substring(0, 1), s -> s));
            System.out.println(result);
        } catch (IllegalStateException e) {
            System.out.println("Duplicates keys in toUnmodifiableMap.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }
    }

}
