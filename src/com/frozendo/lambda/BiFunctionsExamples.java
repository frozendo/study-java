package com.frozendo.lambda;

import com.frozendo.lambda.entity.Produto;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionsExamples {

    public static void main(String[] args) {
        List<Produto> list = Produto.buildList();
        BiFunctionsExamples example = new BiFunctionsExamples();
        example.biConsumerExample(list);
        example.biPredicateExample(list);
        example.biFunctionExample(list);
    }

    private void biConsumerExample(List<Produto> list) {
        System.out.println("##### Executando BiConsumer #####");
        BiConsumer<Produto, String> consumer =
                (produto, toConcat) -> System.out.println(produto.getNome().toUpperCase().concat(toConcat));

        int count = 1;
        for (Produto produto: list) {
            consumer.accept(produto, " - Exemplo " + count);
            count++;
        }

        System.out.println();
    }

    private void biPredicateExample(List<Produto> list) {
        System.out.println("##### Executando BiPredicate #####");
        BiPredicate<Produto, Double> predicate =
                (produto, toCompare) -> produto.getPreco() > toCompare;

        System.out.println(predicate.test(list.get(0), 25D));
        System.out.println(predicate.test(list.get(1), 25D));
        System.out.println(predicate.test(list.get(2), 25D));
        System.out.println(predicate.test(list.get(3), 25D));

        System.out.println();
    }

    private void biFunctionExample(List<Produto> list) {
        System.out.println("##### Executando BiConsumer #####");
        BiFunction<Produto, String, String> function =
                (exampleObject, toConcat) -> exampleObject.getNome().concat(toConcat);

        for (Produto produto: list) {
            System.out.println(function.apply(produto, " - Exemplo"));
        }

        System.out.println();
    }

}
