package com.frozendo.java8.optional;

import com.frozendo.java8.entity.Product;

import java.util.Optional;

public class OptionalMethods {

    public static void main(String[] args) {
        Optional<Product> bladder = Optional.of(Product.bladder());
        Optional<Product> ring = Optional.of(Product.ring());
        Optional<Product> empty = Optional.empty();

        //test filter
        System.out.println("##### filter result #####");
        executeFilter(bladder);
        executeFilter(ring);
        executeFilter(empty);

        System.out.println();

        //test map
        System.out.println("##### map result #####");
        executeMap(bladder);
        executeMap(ring);
        executeMap(empty);

        System.out.println();

        //test flatMap
        System.out.println("##### flatMap result #####");
        executeFlatMap(bladder);
        executeFlatMap(ring);
        executeFlatMap(empty);
    }

    public static void executeFilter(Optional<Product> optional) {
        Optional<Product> optString = optional.filter(Product::isPaid);
        if (optString.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Optional is empty!");
        }
    }

    public static void executeMap(Optional<Product> optional) {
        Optional<Double> optMap = optional.map(product -> product.getPrice());
        if (optMap.isPresent()) {
            System.out.println("Price is: " + optMap.get());
        } else {
            System.out.println("Optional is empty!");
        }
    }

    public static void executeFlatMap(Optional<Product> optional) {

        Optional<Double> optionalResult = optional.flatMap(OptionalMethods::getOptionalValue);

        if (optionalResult.isPresent()) {
            System.out.println("Price of the product is: " + optionalResult.get());
        } else {
            System.out.println("Product is not paid and don't have a price!");
        }
    }

    public static Optional<Double> getOptionalValue(Product product) {
        if (product.isPaid()) {
            return Optional.of(product.getPrice());
        }
        return Optional.empty();
    }

}
