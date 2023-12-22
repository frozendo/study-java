package com.frozendo.java8.lambda.simpleexamples;

import com.frozendo.java8.entity.Product;
import com.frozendo.java8.lambda.interfaces.PaidProduct;
import com.frozendo.java8.lambda.interfaces.PaidProductNewPrice;

public class LambdaExecuteSimilarInterfaces {

    public static void main(String[] args) {
        Product ring = Product.ring();

        System.out.println("Execute method without return");
        executeString((Product item) -> {
            if (item.isPaid()) {
                System.out.println("Product is paid");
            }
        }, ring);

        System.out.println();

        System.out.println("Execute method with return");
        Double output = executeString((Product item) -> {
            if (item.isPaid()) {
                return item.getPrice();
            }
            return 0D;
        }, ring);
        System.out.println("Lambda Return = " + output);
    }

    private static void executeString(PaidProduct lambda, Product product) {
        System.out.println("Call method using interface without return");
        lambda.apply(product);
    }

    private static Double executeString(PaidProductNewPrice lambda, Product product) {
        System.out.println("Call method using interface with return");
        return lambda.apply(product);
    }

}
