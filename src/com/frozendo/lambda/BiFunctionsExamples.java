package com.frozendo.lambda;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionsExamples {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        BiFunctionsExamples execute = new BiFunctionsExamples();
        execute.biConsumerExample(list);
        execute.biPredicateExample(list);
        execute.biFunctionExample(list);
    }

    private void biConsumerExample(List<Product> list) {
        System.out.println("##### Executing a BiConsumer #####");
        BiConsumer<Product, String> consumer =
                (product, toConcat) -> System.out.println(product.getName().toUpperCase().concat(toConcat));

        int count = 1;
        for (Product product : list) {
            consumer.accept(product, " - Example " + count);
            count++;
        }

        System.out.println();
    }

    private void biPredicateExample(List<Product> list) {
        System.out.println("##### Executing a BiPredicate #####");
        BiPredicate<Product, Double> predicate =
                (product, toCompare) -> product.getPrice() > toCompare;

        for (Product product : list) {
            var result = predicate.test(product, 250D);
            System.out.println("The price of the product id: " + product.getId() + " is bigger than 250,00? = " + result);
        }

        System.out.println();
    }

    private void biFunctionExample(List<Product> list) {
        System.out.println("##### Executing a BiFunction #####");
        BiFunction<Product, String, String> function =
                (exampleObject, toConcat) -> exampleObject.getName().concat(toConcat);

        for (Product product : list) {
            System.out.println(function.apply(product, " - Example"));
        }

        System.out.println();
    }

}
