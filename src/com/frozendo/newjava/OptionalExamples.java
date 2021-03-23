package com.frozendo.newjava;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        Optional<String> opt = Optional.of("Optional string with of");
        Optional<String> optNotNullable = Optional.ofNullable("Optional string with ofNullable");
        Optional<String> optNullable = Optional.ofNullable(null);
        Optional<String> empty = Optional.empty();

        //test isPresent method
        System.out.println("*** isPresent result ***");
        useIsPresent(opt);
        useIsPresent(optNotNullable);
        useIsPresent(optNullable);
        useIsPresent(empty);

        System.out.println();

        //test ifPresent method
        System.out.println("*** ifPresent result ***");
        useIfPresent(opt);
        useIfPresent(optNotNullable);
        useIfPresent(optNullable);
        useIfPresent(empty);

        System.out.println();

        //test filter
        System.out.println("*** filter result ***");
        optionalFilter(opt);
        optionalFilter(optNotNullable);
        optionalFilter(optNullable);
        optionalFilter(empty);

        System.out.println();

        //test map
        System.out.println("*** map result ***");
        optionalMap(opt);
        optionalMap(optNotNullable);
        optionalMap(optNullable);
        optionalMap(empty);

        System.out.println();

        //test flatMap
        System.out.println("*** flatMap result ***");
        optionalFlatMap(opt);
        optionalFlatMap(optNotNullable);
        optionalFlatMap(optNullable);
        optionalFlatMap(empty);

        System.out.println();

        //test orElse
        System.out.println("*** orElse result ***");
        optionalOrElse(opt);
        optionalOrElse(optNotNullable);
        optionalOrElse(optNullable);
        optionalOrElse(empty);

        System.out.println();

        //test orElesGet
        System.out.println("*** orElesGet result ***");
        optionalOrElseGet(opt);
        optionalOrElseGet(optNotNullable);
        optionalOrElseGet(optNullable);
        optionalOrElseGet(empty);

        System.out.println();

        //test orElesGetThrow
        System.out.println("*** orElesGetThrow result ***");
        optionalOrElseThrow(opt);
        optionalOrElseThrow(optNotNullable);
        optionalOrElseThrow(optNullable);
        optionalOrElseThrow(empty);
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

    public static void optionalFilter(Optional<String> optional) {
        Optional<String> optString = optional.filter(s -> s.length() > 25);
        useIsPresent(optString);
    }

    public static void optionalMap(Optional<String> optional) {
        Optional<Integer> optMap = optional.map(s -> s.length());
        if (optMap.isPresent()) {
            System.out.println("Map result: " + optMap.get());
        } else {
            System.out.println("Length is 0!");
        }
    }

    public static void optionalFlatMap(Optional<String> optional) {
        Optional<Optional<String>> newOptional = Optional.of(optional);

        Optional<String> optionalResult = newOptional.flatMap(p -> {
            if (p.isPresent()) {
                return p;
            }
            return Optional.empty();
        });

        if (optionalResult.isPresent()) {
            System.out.println("FlatMap result: " + optionalResult.get());
        } else {
            System.out.println("Length is 0!");
        }
    }

    public static void optionalOrElse(Optional<String> optional) {
        String test = optional
                .filter(s -> !s.isEmpty())
                .orElse("Optional empty, execute orElse");
        System.out.println(test);
    }

    public static void optionalOrElseGet(Optional<String> optional) {
        String test = optional
                .filter(s -> !s.isEmpty())
                .orElseGet(String::new);
        System.out.println(test.isEmpty() ? "Optional is empty, orElseGet executed" : test);
    }

    public static void optionalOrElseThrow(Optional<String> optional) {
        try {
            String test = optional
                    .filter(s -> !s.isEmpty())
                    .orElseThrow(RuntimeException::new);
            System.out.println(test);
        } catch(Exception e) {
            System.out.println("Optional is empty, orElseThrow executed");
        }
    }

}
