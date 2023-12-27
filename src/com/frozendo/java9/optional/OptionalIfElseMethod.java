package com.frozendo.java9.optional;

import com.frozendo.java8.entity.Product;

import java.util.Optional;

public class OptionalIfElseMethod {

    public static void main(String[] args) {
        compareIfPresentWithIfPresentOrElse();

        System.out.println();

        ifPresentOrElseWithEmptyValue();

        System.out.println();

        ifPresentOrElseWithNullValue();
    }

    private static void compareIfPresentWithIfPresentOrElse() {
        System.out.println("Compare ifPresent and ifPresentOrElse");
        Optional<Product> value = Optional.of(Product.bicycle());
        value.ifPresent(
                ld -> System.out.println("Using ifPresent = " + ld));
        value.ifPresentOrElse(
                ld -> System.out.println("Using ifPresentOrElse = " + ld),
                Product::new);
    }

    private static void ifPresentOrElseWithEmptyValue() {
        System.out.println("When optional is empty");
        Optional<Product> empty = Optional.empty();
        empty.ifPresent(
                ld -> System.out.println("Using ifPresent: " + ld));
        empty.ifPresentOrElse(
                ld -> System.out.println("Using ifPresentOrElse = " + ld),
                () -> System.out.println("Execute orElse function = " + new Product()));
    }

    private static void ifPresentOrElseWithNullValue() {
        System.out.println("Pass consumer null");
        Optional<Product> consumerNull = Optional.of(Product.ring());

        try {
            consumerNull.ifPresentOrElse(
                    null,
                    () -> System.out.println("Execute orElse function = " + new Product()));
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException in method 'ifPresentOrElse'");
        } catch (Exception ex) {
            System.out.println("Other exception " + ex.getMessage());
        }
    }

}
