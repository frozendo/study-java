package com.frozendo.java8.lambda.bifunctions;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.BiPredicate;

public class LambdaBiPredicate {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        BiPredicate<Product, Double> predicate =
                (product, toCompare) -> product.getPrice() > toCompare;

        for (Product product : list) {
            boolean result = predicate.test(product, 250D);
            System.out.println("The price of the product id: " + product.getId() + " is bigger than 250,00? = " + result);
        }

    }

}
