package com.frozendo.java8.lambda.methodreference;

import com.frozendo.entity.Product;

import java.util.List;

public class MethodReferenceInstanceMethod {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        System.out.println("Print product name using getName from Product class");
        list.stream().map(Product::getName).forEach(System.out::println);

        System.out.println();

        System.out.println("Print product price using getPrice from Product class");
        list.stream().map(Product::getPrice).forEach(System.out::println);
    }

}
