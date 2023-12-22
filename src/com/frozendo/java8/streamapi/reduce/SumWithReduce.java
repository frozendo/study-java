package com.frozendo.java8.streamapi.reduce;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.OptionalDouble;

public class SumWithReduce {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        sumWithoutInitialNumber(list);
        sumWithInitialValue(list);
        reduceFunctionWithBinaryOperator(list);
    }

    private static void sumWithoutInitialNumber(List<Product> list) {
        OptionalDouble total = list.stream()
                .mapToDouble(Product::getPrice)
                .reduce((sum, value) -> sum + value);
        System.out.println("Sum without initial value = " + total.getAsDouble());
        System.out.println();
    }

    private static void sumWithInitialValue(List<Product> list) {
        Double total = list.stream()
                .map(i -> i.getPrice())
                .reduce(100.0, (sum, value) -> sum + value);
        System.out.println("Sum initiate with 100 = " + total);
        System.out.println();
    }

    private static void reduceFunctionWithBinaryOperator(List<Product> list) {
        Integer result = list.stream()
                .map(i -> i.getName())
                .reduce(0,
                        (sum, value) -> sum + value.length(),
                        (value1, value2) -> value1 + value2);

        System.out.println("Total product name length = " + result);
        System.out.println();
    }

}
