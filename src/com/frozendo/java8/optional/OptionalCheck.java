package com.frozendo.java8.optional;

import java.util.Optional;

public class OptionalCheck {

    public static void main(String[] args) {
        OptionalCheck execute = new OptionalCheck();

        Optional<String> opt = Optional.of("Optional string with of");
        Optional<String> optNotNullable = Optional.ofNullable("Optional string with ofNullable");
        Optional<String> optNullable = Optional.ofNullable(null);
        Optional<String> empty = Optional.empty();

        //test isPresent method
        System.out.println("##### isPresent result #####");
        useIsPresent(opt);
        useIsPresent(optNotNullable);
        useIsPresent(optNullable);
        useIsPresent(empty);

        System.out.println();

        //test ifPresent method
        System.out.println("##### ifPresent result #####");
        useIfPresent(opt);
        useIfPresent(optNotNullable);
        useIfPresent(optNullable);
        useIfPresent(empty);
    }

    public static void useIsPresent(Optional<String> optional) {
        if (optional.isPresent()) {
            System.out.println("Value is: " + optional.get());
        } else {
            System.out.println("Optional is empty!");
        }
    }

    public static void useIfPresent(Optional<String> optional) {
        optional.ifPresent(s -> System.out.println("Value with ifPresent: " + s));
    }

}
