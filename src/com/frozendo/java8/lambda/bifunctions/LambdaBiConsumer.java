package com.frozendo.java8.lambda.bifunctions;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.BiConsumer;

public class LambdaBiConsumer {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        BiConsumer<Product, String> consumer =
                (product, toConcat) -> System.out.println(product.getName().concat(toConcat));

        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            consumer.accept(product, " - Example " + i);
        }

    }

}
