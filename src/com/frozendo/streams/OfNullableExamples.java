package com.frozendo.streams;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class OfNullableExamples {

    public static void main(String[] args) {
        OfNullableExamples execute = new OfNullableExamples();
        execute.usingStreamOf();
        execute.usingStreamOfWithNullElement();
        execute.usingStreamOfNullable();
        execute.usingStreamOfNullableWithNullElement();
        execute.usingStreamOfNullableWithFlatMap();
    }
    
    private void usingStreamOf() {
        System.out.println("##### Using 'of' to create a stream ######");

        System.out.println("Simple stream with one element");

        Stream.of("yellow")
            .forEach(System.out::println);

        System.out.println("Stream with multi elements");

        Stream.of("blue", "red", "green", "purple")
            .forEach(System.out::println);
            
            System.out.println();
    }

    private void usingStreamOfWithNullElement() {
        System.out.println("##### Using 'of' with null value ######");

        try {
            Stream.of(null)
                .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error when use 'of' with null value");
            ex.printStackTrace();
        }
            
        System.out.println();
    }

    private void usingStreamOfNullable() {
        System.out.println("##### Using 'ofNullable' to create a stream with elements ######");

        Stream.ofNullable("yellow")
            .forEach(System.out::println);
            
        System.out.println();

    }

    private void usingStreamOfNullableWithNullElement() {
        System.out.println("##### Using 'ofNullable' to create a stream with null value ######");

        Stream.ofNullable(null)
            .forEach(System.out::println);
        System.out.println("Nothing is printed but a NullPointException don't occur");
            
        System.out.println();

    }

    private void usingStreamOfNullableWithFlatMap() {
        System.out.println("##### Combine ofNullable and flatMap to create a strem with multi elements #####");

        List<String> colors = new ArrayList<>();
        colors.add("yellow");
        colors.add(null);
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add(null);
        colors.add("purple");
        
        colors.stream()
            .flatMap(value -> Stream.ofNullable(value))
            .forEach(System.out::println);

        System.out.println();
    
    }

    
}
