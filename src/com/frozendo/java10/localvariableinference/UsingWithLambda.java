package com.frozendo.java10.localvariableinference;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.BiConsumer;

public class UsingWithLambda {

    public static void main(String[] args) {
        lambdaWithExplicitTypes();
        lambdaWithTypeInference();
        lambdaWithVar();
    }

    private static void lambdaWithExplicitTypes() {
        var list = Product.buildList();

        BiConsumer<Product, String> consumer =
                (Product product, String toConcat) -> System.out.println(product.getName().concat(toConcat));

        run(list, consumer);
    }

    private static void lambdaWithTypeInference() {
        var list = Product.buildList();

        BiConsumer<Product, String> consumer =
                (product, toConcat) -> System.out.println(product.getName().concat(toConcat));

        run(list, consumer);
    }

    private static void lambdaWithVar() {
        var list = Product.buildList();

        BiConsumer<Product, String> consumer =
                (var product, var toConcat) -> System.out.println(product.getName().concat(toConcat));

        run(list, consumer);
    }

    private static void run(List<Product> list, BiConsumer<Product, String> consumer) {
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            consumer.accept(product, " - Example " + i);
        }
        System.out.println();
    }

}
