package com.frozendo.java8.lambda.methodreference;

import com.frozendo.java8.entity.Product;

import java.util.List;

public class MethodReferenceAsStatic {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        //using the method of class to print product
        list.forEach(MethodReferenceAsStatic::printProduct);

        System.out.println("Teste");

        //using Long class static method
        list.stream().map(item -> item.getId()).forEach(Long::toBinaryString);
    }

    private static void printProduct(Product product) {
        System.out.println(product);
    }

}
