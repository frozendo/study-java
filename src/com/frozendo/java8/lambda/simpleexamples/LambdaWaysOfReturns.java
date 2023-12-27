package com.frozendo.java8.lambda.simpleexamples;

import com.frozendo.entity.Product;
import com.frozendo.java8.lambda.interfaces.ProductPriceMultiplier;

public class LambdaWaysOfReturns {
    public static void main(String[] args) {

        Product product = new Product();

        System.out.println("Function that execute one command and has an implicit return");
        ProductPriceMultiplier exampleNumber1 = (item, multiplier) -> item.getPrice() * multiplier;
        System.out.println(exampleNumber1.apply(product, 2D));

        System.out.println();

        System.out.println("Function that execute more than one command and has an explicit return");
        ProductPriceMultiplier exampleNumber2 = (item, multiplier) -> {
            boolean isNaN = item.getPrice().isNaN();
            if (isNaN) {
                return 0D;
            }
            return item.getPrice() * multiplier;
        };
        System.out.println(exampleNumber2.apply(product, 4D));
    }
}
