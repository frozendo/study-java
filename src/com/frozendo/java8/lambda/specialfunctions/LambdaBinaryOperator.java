package com.frozendo.java8.lambda.specialfunctions;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class LambdaBinaryOperator {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        DoubleBinaryOperator doubleBinaryOperator = (value1, value2) -> value1 + value2;

        for (Product product : list) {
            Double result = doubleBinaryOperator.applyAsDouble(product.getPrice(), 10D);
            System.out.println("The price of the product id: " + product.getId() + " is = " + result);
        }
    }

}
