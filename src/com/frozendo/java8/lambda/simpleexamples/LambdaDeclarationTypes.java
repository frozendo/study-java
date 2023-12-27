package com.frozendo.java8.lambda.simpleexamples;

import com.frozendo.entity.Product;

import java.util.List;

public class LambdaDeclarationTypes {
    public static void main(String[] args) {

        List<Product> list = Product.buildList();

        System.out.println("Simple Lambda");
        list.forEach((Product product) -> {
            String upperCase = product.getName().toUpperCase();
            System.out.println(upperCase);
        });
        System.out.println();

        System.out.println("Parameter with variable type inferred");
        list.forEach(product -> {
            Double price = product.getPrice();
            String name = product.getName();
            System.out.println("Lambda for product " + name + " with price " + price);
        });
        System.out.println();

        System.out.println("Block without bracket for a simple expression");
        list.forEach(product -> System.out.println(product.getName().toLowerCase()));
        System.out.println();
    }
}
