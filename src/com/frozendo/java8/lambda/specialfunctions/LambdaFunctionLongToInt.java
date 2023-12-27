package com.frozendo.java8.lambda.specialfunctions;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.LongToDoubleFunction;

public class LambdaFunctionLongToInt {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        LongToDoubleFunction longToIntFunction = value -> (double) value;
        for (Product product : list) {
            System.out.println("Product id as double = " + longToIntFunction.applyAsDouble(product.getId()));
        }
    }

}
