package com.frozendo.java8.lambda.specialfunctions;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.ToLongBiFunction;

public class LambdaBiFunctionToLong {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        ToLongBiFunction<Double, Integer> toLongBiFunction = (value1, value2) -> value1.longValue() + value2;
        for (Product product : list) {
            System.out.println("Product price as long (plus int value) = " + toLongBiFunction.applyAsLong(product.getPrice(), 10));
        }
    }

}
