package com.frozendo.java8.lambda.functions;

import com.frozendo.entity.Product;

import java.util.function.Supplier;

public class LambdaSupplier {

    public static void main(String[] args) {
        //Supplier function = receive any parameters and return an object
        Supplier<Product> supplier = () -> new Product();

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }

}
