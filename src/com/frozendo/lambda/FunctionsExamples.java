package com.frozendo.lambda;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionsExamples {

    public static void main(String[] args) {
        FunctionsExamples execute = new FunctionsExamples();
        execute.supplierExample();

        List<Product> list = Product.buildList();

        execute.consumerExample(list);
        execute.predicateExample(list);
        execute.functionExample(list);
    }

    private void supplierExample() {
        System.out.println("##### Create a factory of objects with supplier #####");
        Supplier<Product> supplier = Product::new;

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());

        System.out.println();

    }

    private void consumerExample(List<Product> list) {
        System.out.println("##### Executing functions with consumer interface #####");

        Consumer<Product> consumer = product -> System.out.println(product.getName().toUpperCase());
        list.forEach(consumer);

        System.out.println();
    }

    private void predicateExample(List<Product> list) {
        System.out.println("##### Executing verification with predicate #####");
        Predicate<Product> predicate = product -> product.getPrice() > 50;

        list.stream().filter(predicate).forEach(item -> System.out.println(item.getName()));
        System.out.println();
        System.out.println(list.stream().anyMatch(predicate));

        System.out.println();
    }

    private void functionExample(List<Product> list) {
        System.out.println("##### Executing interface function #####");
        Function<Product, String> function = Product::getName;

        System.out.println(list.stream().map(function).collect(Collectors.toList()));

        System.out.println();
    }

}
