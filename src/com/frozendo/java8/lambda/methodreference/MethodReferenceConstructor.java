package com.frozendo.java8.lambda.methodreference;

import com.frozendo.java8.entity.Product;

import java.util.function.Supplier;

public class MethodReferenceConstructor {

    public static void main(String[] args) {
        Supplier<Product> supplier = Product::new;

        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }

}
