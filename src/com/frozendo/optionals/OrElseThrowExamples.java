package com.frozendo.optionals;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OrElseThrowExamples {

    public static void main(String[] args) {
        OrElseThrowExamples execute = new OrElseThrowExamples();
        execute.orElseThrowWithLambdaParameter();
        execute.orElseThrowWithoutParameter();
        execute.optionalGetMethod();

        execute.emptyOptionalAndOldOrElseThrow();
        execute.emptyOptionalAndNewOrElseThrow();
        execute.emptyUsingGet();
    }

    private void orElseThrowWithLambdaParameter() {
        System.out.println("##### Using exist orElseThrow #####");
        var opt = Optional.of("This is an optional");
        System.out.println(opt.orElseThrow(RuntimeException::new));
        System.out.println();
    }

    private void orElseThrowWithoutParameter() {
        System.out.println("##### Using new orElseThrow #####");
        var opt = Optional.of("This is an optional");
        System.out.println(opt.orElseThrow());
        System.out.println();
    }

    private void optionalGetMethod() {
        System.out.println("##### Using 'get' method #####");
        var opt = Optional.of("This is an optional");
        System.out.println(opt.get());
        System.out.println();
    }

    private void emptyOptionalAndOldOrElseThrow() {
        System.out.println("##### Using exist orElseThrow and throw an RuntimeException #####");
        var empty = Optional.empty();
        try {
            System.out.println(empty.orElseThrow(() -> new RuntimeException("Create exception manually")));
        } catch (RuntimeException ex) {
            System.out.println("orElseThrow exception: " + ex.getMessage());
        }
        System.out.println();
    }

    private void emptyOptionalAndNewOrElseThrow() {
        System.out.println("##### Using new orElseThrow and throw an NoSuchElementException #####");
        var empty = Optional.empty();
        try {
            System.out.println(empty.orElseThrow());
        } catch (NoSuchElementException ex) {
            System.out.println("method 'orElseThrow' exception: " + ex.getMessage());
        }
        System.out.println();

    }

    private void emptyUsingGet() {
        System.out.println("##### Using 'get' method and throw an NoSuchElementException #####");
        var empty = Optional.empty();
        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException ex) {
            System.out.println("method 'get' exception: " + ex.getMessage());
        }
        System.out.println();

    }

}
