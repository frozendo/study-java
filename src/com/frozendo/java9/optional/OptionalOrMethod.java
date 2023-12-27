package com.frozendo.java9.optional;

import com.frozendo.entity.Product;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalOrMethod {

    public static void main(String[] args) {
        orMethodGetOriginalOption();

        System.out.println();

        orMethodGetValueFromOR();

        System.out.println();

        orMethodWithNullValue();
    }

    private static void orMethodGetOriginalOption() {
        System.out.println("Optional with value");
        Optional<Product> original = Optional.of(Product.bicycle());
        Optional<Product> resultOpt = original.or(Optional::empty);

        System.out.println("Result: " + resultOpt);
        System.out.println("Instance is equal?: " + (resultOpt == original));
    }

    private static void orMethodGetValueFromOR() {
        System.out.println("Optional empty");
        Optional<Product> empty = Optional.empty();
        Optional<Product> resultEmpty = empty.or(buildLocalDate());
        System.out.println("Result: " + resultEmpty);
        System.out.println("Instance is equal?: " + (resultEmpty == empty));
    }

    private static void orMethodWithNullValue() {
        System.out.println("Parameter null");
        Optional<Product> original = Optional.of(Product.bicycle());
        try {
            Optional<Product> resultException = original.or(null);
            System.out.println("Result: " + resultException);
            System.out.println("Instance is equal?: " + (resultException == original));
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException in method 'or'");
        } catch (Exception ex) {
            System.out.println("Other exception " + ex.getMessage());
        }
    }

    private static Supplier<Optional<Product>> buildLocalDate() {
        return () -> Optional.of(new Product());
    }

}
