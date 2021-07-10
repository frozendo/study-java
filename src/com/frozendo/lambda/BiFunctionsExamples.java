package com.frozendo.lambda;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionsExamples {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        BiFunctionsExamples example = new BiFunctionsExamples();
        example.biConsumerExample(list);
        example.biPredicateExample(list);
        example.biFunctionExample(list);
    }

    private void biConsumerExample(List<Product> list) {
        System.out.println("##### Executando BiConsumer #####");
        BiConsumer<Product, String> consumer =
                (produto, toConcat) -> System.out.println(produto.getNome().toUpperCase().concat(toConcat));

        int count = 1;
        for (Product product : list) {
            consumer.accept(product, " - Exemplo " + count);
            count++;
        }

        System.out.println();
    }

    private void biPredicateExample(List<Product> list) {
        System.out.println("##### Executando BiPredicate #####");
        BiPredicate<Product, Double> predicate =
                (produto, toCompare) -> produto.getPreco() > toCompare;

        System.out.println(predicate.test(list.get(0), 25D));
        System.out.println(predicate.test(list.get(1), 25D));
        System.out.println(predicate.test(list.get(2), 25D));
        System.out.println(predicate.test(list.get(3), 25D));

        System.out.println();
    }

    private void biFunctionExample(List<Product> list) {
        System.out.println("##### Executando BiConsumer #####");
        BiFunction<Product, String, String> function =
                (exampleObject, toConcat) -> exampleObject.getNome().concat(toConcat);

        for (Product product : list) {
            System.out.println(function.apply(product, " - Exemplo"));
        }

        System.out.println();
    }

}
