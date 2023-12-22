package com.frozendo.java8.streamapi.reduce;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.Optional;

public class ConcatWithReduce {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        concatWithoutInitialString(list);
        concatWithInitialString(list);
        reduceFunctionWithBinaryOperator(list);
    }

    private static void concatWithoutInitialString(List<Product> list) {
        Optional<String> result = list.stream()
                .map(Product::getName)
                .reduce((word, value) -> word.concat(", ").concat(value));

        System.out.println("Reduce concat result = " + result.get());
        System.out.println();
    }

    private static void concatWithInitialString(List<Product> list) {
        String result = list.stream()
                .map(Product::getName)
                .reduce(
                        "Concat with initial value = ",
                        (word, value) -> word.concat(value).concat(", "));

        System.out.println(result);
        System.out.println();
    }

    private static void reduceFunctionWithBinaryOperator(List<Product> list) {
        String result = list.stream()
                .map(i -> i.getId())
                .reduce("Concat numbers in a string = ",
                        (word, value) -> word.concat(value.toString()),
                        (value1, value2) -> value1.concat(", ").concat(value2));

        System.out.println(result);
    }

}
