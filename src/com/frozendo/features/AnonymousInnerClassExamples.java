package com.frozendo.features;

import java.util.ArrayList;
import java.util.List;

public class AnonymousInnerClassExamples {

    public static void main(String[] args) {

        AnonymousInnerClassExamples execute = new AnonymousInnerClassExamples();
        execute.diamondOperatorExamples();
        execute.anonymousClassExamples();
        execute.anonymousClassWithDiamondOperator();

    }

    private void diamondOperatorExamples() {
        System.out.println("##### Using diamond operator #####");
        List<String> withoutDiamondList = new ArrayList<String>();
        List<String> withDiamondList = new ArrayList<>();

        System.out.println("List of string created without diamond operator = " + withoutDiamondList.getClass());
        System.out.println("List of string created with diamond operator = " + withDiamondList.getClass());
        System.out.println();
    }

    private void anonymousClassExamples() {
        System.out.println("##### Anonymous class examples #####");

        System.out.println("Implements an interface when instantiating a variable");
        Hello helloSpanish = new Hello() {
            @Override
            public String greet(String name, String complement) {
                return "Hola " + name + " " + complement;
            }
        };
        System.out.println(helloSpanish.greet("Pablo", "es un placer conocerte"));

        System.out.println("Implements an abstract class when instantiating a variable");
        Hello helloPortuguese = new HelloInPortuguese() {
            @Override
            public String greet(String name, String complement) {
                return "Olá " + name + " " + complement;
            }
        };
        System.out.println(helloPortuguese.greet("Paulo", "bom dia"));

        System.out.println("Create a class inside method and use a variable of this class");
        class HelloInEnglish implements Hello {
            public String greet(String name, String complement) {
                return "Hello " + name + " " + complement;
            }
        }

        Hello helloEnsligh = new HelloInEnglish();
        System.out.println(helloEnsligh.greet("Paul", "welcome"));
        System.out.println();
    }

    private void anonymousClassWithDiamondOperator() {
        System.out.println("#### Using anonymous class with diamond operator #####");
        ExampleMath<Integer> integerExample = new ExampleMath<>() {
            @Override
            public Integer sum(Integer x, Integer y) {
                return x + y;
            }

            @Override
            public Integer multi(Integer x, Integer y) {
                return x * y;
            }
        };
        System.out.println("Integer anonymous class");
        System.out.println("sum = " + integerExample.sum(10, 20) + " and multi = " + integerExample.multi(2, 5));

        ExampleMath<Double> doubleExampleMath = new ExampleMath<>() {
            @Override
            public Double sum(Double x, Double y) {
                return x + y;
            }

            @Override
            public Double multi(Double x, Double y) {
                return x * y;
            }
        };

        System.out.println("Double anonymous class");
        System.out.println("sum = " + doubleExampleMath.sum(9d, 15d) + " and multi = " + doubleExampleMath.multi(8d, 3d));

        System.out.println();
    }

    private abstract class HelloInPortuguese implements Hello {

        @Override
        public abstract String greet(String name, String complement);
    }

    private interface Hello {
        String greet(String name, String complement);
    }

    private interface ExampleMath<T> {
        T sum(T x, T y);

        T multi(T x, T y);
    }

}
