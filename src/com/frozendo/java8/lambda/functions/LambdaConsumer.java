package com.frozendo.java8.lambda.functions;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.Consumer;

public class LambdaConsumer {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        //Consumer function = receive an object and return nothing
        Consumer<Product> consumer = product -> System.out.println(product.getName().toUpperCase());

        list.forEach(consumer);
    }

}
