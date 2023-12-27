package com.frozendo.java10.orelsethrow;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UsingGetEquivalent {

    public static void main(String[] args) {
        System.out.println("Using get with same behavior of orElseThrow");
        var opt = Optional.of("This is an optional");
        System.out.println(opt.get());

        System.out.println();

        System.out.println("Using get with same behavior of orElseThrow");
        var empty = Optional.empty();
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println("Optional empty throw default exception = " + ex.getMessage());
        }
    }

}
