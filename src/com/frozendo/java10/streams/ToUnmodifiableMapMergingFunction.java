package com.frozendo.java10.streams;

import com.frozendo.entity.Product;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ToUnmodifiableMapMergingFunction {

    public static void main(String[] args) {
        var list = Product.buildList();
        final Map<String, String> result = list.stream()
                .map(Product::getName)
                .collect(Collectors.toUnmodifiableMap(s -> s.substring(0, 1), s -> s, callMergeFunction()));
        System.out.println("Result of merge: " + result);
    }

    private static BinaryOperator<String> callMergeFunction() {
        return (s, x) -> s.concat(",").concat(x);
    }

}
