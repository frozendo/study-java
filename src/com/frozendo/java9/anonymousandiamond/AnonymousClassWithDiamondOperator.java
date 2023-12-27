package com.frozendo.java9.anonymousandiamond;

public class AnonymousClassWithDiamondOperator {

    public static void main(String[] args) {
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

        System.out.println();

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
    }

    private interface ExampleMath<T> {
        T sum(T x, T y);

        T multi(T x, T y);
    }

}
