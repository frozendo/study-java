package com.frozendo.java8.lambda.functions;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaFunction {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        //Function function = receive an object and return another object
        //In this case, receive an Product and return a String
        Function<Product, String> function = Product::getName;

        System.out.println(list.stream().map(function).collect(Collectors.toList()));
    }

}
