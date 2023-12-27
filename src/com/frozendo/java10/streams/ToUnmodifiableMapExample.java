package com.frozendo.java10.streams;

import com.frozendo.entity.Product;

import java.util.Map;
import java.util.stream.Collectors;

public class ToUnmodifiableMapExample {

    public static void main(String[] args) {
        var list = Product.buildList();
        final Map<String, String> result = list.stream()
                .map(Product::getName)
                .collect(Collectors.toUnmodifiableMap(s -> s.substring(0,2), s -> s));
        System.out.println("List result: " + result);

        try {
            result.put("X", "Try add in immutable collection");
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable map.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }
    }

}
