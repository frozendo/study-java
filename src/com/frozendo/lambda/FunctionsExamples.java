package com.frozendo.lambda;

import com.frozendo.lambda.entity.Produto;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionsExamples {

    public static void main(String[] args) {
        FunctionsExamples example = new FunctionsExamples();
        example.supplierExample();

        List<Produto> list = Produto.buildList();

        example.consumerExample(list);
        example.predicateExample(list);
        example.functionExample(list);
    }

    private void supplierExample() {
        System.out.println("##### Criando uma fabrica de objetos com supplier #####");
        Supplier<Produto> supplier = () -> new Produto();

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());

        System.out.println();

    }

    private void consumerExample(List<Produto> list) {
        System.out.println("##### Executando funções com interface consumer #####");

        Consumer<Produto> consumer = produto -> System.out.print(produto.getNome().toUpperCase());
        list.forEach(consumer);
        System.out.println();
        list.stream().peek(consumer);

        System.out.println();
    }

    private void predicateExample(List<Produto> list) {
        System.out.println("##### Executando verificações com predicate #####");
        Predicate<Produto> predicate = produto -> produto.getPreco() > 25;

        list.stream().filter(predicate).forEach(item -> System.out.println(item.getNome()));
        System.out.println();
        System.out.println(list.stream().anyMatch(predicate));

        System.out.println();
    }

    private void functionExample(List<Produto> list) {
        System.out.println("##### Executando interface function #####");
        Function<Produto, String> function = exampleObject -> exampleObject.getNome();

        System.out.println(list.stream().map(function).collect(Collectors.toList()));

        System.out.println();

    }

}
