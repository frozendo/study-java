package com.frozendo.java10.orelsethrow;

import java.util.Optional;

public class OrElseThrowWithPreJava10 {

    public static void main(String[] args) {
        System.out.println("Using orElseThrow when optional is not empty");
        var opt = Optional.of("This is an optional");
        System.out.println(opt.orElseThrow(RuntimeException::new));

        System.out.println();

        System.out.println("Using orElseThrow when optional is empty");
        var empty = Optional.empty();
        try {
            System.out.println(empty.orElseThrow(() -> new RuntimeException("Error on optional")));
        } catch (RuntimeException ex) {
            System.out.println("Optional empty throw an excpetion = " + ex.getMessage());
        }
    }

}
