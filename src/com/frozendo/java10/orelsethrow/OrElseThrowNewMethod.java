package com.frozendo.java10.orelsethrow;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OrElseThrowNewMethod {

    public static void main(String[] args) {
        System.out.println("Using orElseThrow when optional is not empty");
        var opt = Optional.of("This is an optional");
        System.out.println(opt.orElseThrow());

        System.out.println();

        System.out.println("Using orElseThrow when optional is empty");
        var empty = Optional.empty();
        try {
            System.out.println(empty.orElseThrow());
        } catch (NoSuchElementException ex) {
            System.out.println("Optional empty throw default exception = " + ex.getMessage());
        }
    }

}
