package com.frozendo.lambda;

import com.frozendo.entity.Product;
import com.frozendo.lambda.interfaces.NumberProcess;
import com.frozendo.lambda.interfaces.StringProcess;
import com.frozendo.lambda.interfaces.StringProcessWithReturn;

import java.util.List;

public class LambdaExamples {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        LambdaExamples execute = new LambdaExamples();

        execute.lambdaDeclaretionsType(list);
        execute.lambdasTypeOfReturn(list.get(0));
        execute.executeSimilarInterfaces(list.get(0));
    }

    private void lambdaDeclaretionsType(List<Product> list) {
        System.out.println("##### Different ways to declare a lambda function #####");

        System.out.println("Simple Lambda");
        list.forEach((Product product) -> { System.out.println(product.getName().toUpperCase()); });
        System.out.println();

        System.out.println("Parameter with variable type inferred");
        list.forEach(product -> { System.out.println(product.getPrice()); });
        System.out.println();

        System.out.println("Block without bracket for a simple expression");
        list.forEach(product -> System.out.println(product.getName().toLowerCase()));
        System.out.println();
    }

    private void lambdasTypeOfReturn(Product product) {
        System.out.println("##### Different ways of lambda to return values #####");

        System.out.println("Function that execute once and has an implicit return");
        NumberProcess<Double> exampleNumber1 = (value1, value2) -> value1 + value2;
        System.out.println(exampleNumber1.apply(product.getPrice(), 2D));
        System.out.println();

        System.out.println("Function that execute multiple times and has an explicit return");
        NumberProcess<Double> exampleNumber2 = (value1, value2) -> value1 + value2;
        System.out.println(exampleNumber2.apply(product.getPrice(), 4D));
        System.out.println();
    }

    private void executeSimilarInterfaces(Product product) {
        System.out.println("##### Same lambda function run in different interfaces #####");

        System.out.println("Execute method without return");
        executeString((String value) -> {
                value = value.toUpperCase();
                value.trim();
            }, product.getName());
        System.out.println();

        System.out.println("Execute method with return");
        String output = executeString((String value) -> {
                value = value.toUpperCase();
                return value.trim();
            }, product.getName());
        System.out.println("Lambda return = " + output);
        System.out.println();
    }

    private void executeString(StringProcess lambda, String value) {
        lambda.apply(value);
    }

    private String executeString(StringProcessWithReturn lambda, String value) {
        return lambda.apply(value);
    }
}
