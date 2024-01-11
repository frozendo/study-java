package com.frozendo.java10.localvariableinference;

import com.frozendo.entity.Product;

public class ForLoopAndStaticBlock {

    public static void main(String[] args) {
        System.out.println("Using var to initialize a forloop variable");
        var products = Product.buildList();
        for (var i = 0; i < products.size(); i++) {
            var product = products.get(i);
            System.out.println(product);
        }
    }

    static {
        var defaultProduct = new Product();
        System.out.println("Print default product");
        System.out.println(defaultProduct);
        System.out.println();
    }

}
