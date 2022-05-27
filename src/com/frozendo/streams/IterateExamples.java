package com.frozendo.streams;

import java.util.stream.Stream;

public class IterateExamples {
    
    public static void main(String[] args) {
        IterateExamples execute = new IterateExamples();
        execute.usingIterateFromJava8();
        execute.usingIterateFromJava9();
        execute.generateFibonacciWithJava8Version();
        execute.generateFibonacciWithJava9Version();
    }

    private void usingIterateFromJava8() {
        System.out.println("##### Using limit to stop iterate from java 8 #####");

        Stream.iterate(1, n -> n * 2)
            .limit(10)
            .forEach(System.out::println);
            
        System.out.println();

    }

    private void generateFibonacciWithJava8Version() {
        System.out.println("##### Generate Fibonacci with java 8 version #####");

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
		    .limit(20)
		    .map(n -> n[0])
            .forEach(System.out::println);

        System.out.println();
    }

    private void usingIterateFromJava9() {
        System.out.println("##### Using iterate from java 9 #####");

        Stream.iterate(1, 
                        n -> n < 1000, 
                        n -> n * 2
            ).forEach(System.out::println);

        System.out.println();
    }

    private void generateFibonacciWithJava9Version() {
        System.out.println("##### Generate Fibonacci with java 9 version #####");

        Stream.iterate(new int[]{0, 1, 0}, 
                        n -> n[2] < 20,
                        n -> new int[]{n[1], n[0] + n[1], n[2] + 1}
            ).map(n -> n[0])
            .forEach(System.out::println);

        System.out.println();
    }

}
