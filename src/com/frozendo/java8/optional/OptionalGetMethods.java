package com.frozendo.java8.optional;

import com.frozendo.java8.entity.Product;

import java.util.Optional;

public class OptionalGetMethods {

    public static void main(String[] args) {
        Optional<Product> bicycle = Optional.of(Product.bicycle());
        Optional<Product> painting = Optional.of(Product.painting());
        Optional<Product> empty = Optional.empty();

        //test orElse
        System.out.println("##### orElse result #####");
        executeOptionalOrElse(bicycle);
        executeOptionalOrElse(painting);
        executeOptionalOrElse(empty);

        System.out.println();

        //test orElesGet
        System.out.println("##### orElesGet result #####");
        executeOptionalOrElseGet(bicycle);
        executeOptionalOrElseGet(painting);
        executeOptionalOrElseGet(empty);

        System.out.println();

        //test orElesGetThrow
        System.out.println("##### orElesGetThrow result #####");
        executeOptionalOrElseThrow(bicycle);
        executeOptionalOrElseThrow(painting);
        executeOptionalOrElseThrow(empty);

    }

    public static void executeOptionalOrElse(Optional<Product> optional) {
        Product test = optional
                .filter(product -> product.isPaid())
                .orElse(new Product());
        System.out.println(test);
    }

    public static void executeOptionalOrElseGet(Optional<Product> optional) {
        Product test = optional
                .filter(Product::isPaid)
                .orElseGet(Product::new);
        System.out.println(test);
    }

    public static void executeOptionalOrElseThrow(Optional<Product> optional) {
        try {
            Product test = optional
                    .filter(Product::isPaid)
                    .orElseThrow(RuntimeException::new);
            System.out.println(test);
        } catch(Exception e) {
            System.out.println("Optional is empty, orElseThrow executed");
        }
    }

}
