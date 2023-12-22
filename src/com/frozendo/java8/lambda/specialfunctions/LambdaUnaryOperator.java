package com.frozendo.java8.lambda.specialfunctions;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.function.UnaryOperator;

public class LambdaUnaryOperator {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        UnaryOperator<String> unaryOperator = value -> value.toUpperCase();

        for (Product product : list) {
            String unaryOut = unaryOperator.apply(product.getName());
            System.out.println("Unary Output = " + unaryOut);
        }
    }

}
