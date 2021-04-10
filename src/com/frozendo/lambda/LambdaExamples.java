package com.frozendo.lambda;

import com.frozendo.lambda.entity.Produto;
import com.frozendo.lambda.interfaces.NumberProcess;
import com.frozendo.lambda.interfaces.StringProcess;
import com.frozendo.lambda.interfaces.StringProcessWithReturn;

import java.util.List;

public class LambdaExamples {

    public static void main(String[] args) {
        List<Produto> list = Produto.buildList();
        LambdaExamples example = new LambdaExamples();

        example.lambdaDeclaretionsType(list);
        example.lambdasTypeOfReturn(list.get(0));
        example.executeSimilarInterfaces(list.get(0));
    }

    private void lambdaDeclaretionsType(List<Produto> list) {
        System.out.println("##### Formas de declarar um lambda #####");

        System.out.println("Lambda simples");
        list.forEach((Produto produto) -> { System.out.println(produto.getNome().toUpperCase()); });
        System.out.println();

        System.out.println("Parâmetro com o tipo de variável inferido");
        list.forEach(produto -> { System.out.println(produto.getPreco()); });
        System.out.println();

        System.out.println("Bloco sem chaves para uma expressão simples");
        list.forEach(produto -> System.out.println(produto.getNome().toLowerCase()));
        System.out.println();
    }

    private void lambdasTypeOfReturn(Produto produto) {
        System.out.println("##### Formas de retorno de uma lambda #####");

        System.out.println("Função com unica execução e retorno implicito");
        NumberProcess<Double> exampleNumber1 = (value1, value2) -> value1 + value2;
        System.out.println(exampleNumber1.apply(produto.getPreco(), 2D));
        System.out.println();

        System.out.println("Função com multiplas execuções e retorno explicito");
        NumberProcess<Double> exampleNumber2 = (value1, value2) -> value1 + value2;
        System.out.println(exampleNumber2.apply(produto.getPreco(), 4D));
        System.out.println();
    }

    private void executeSimilarInterfaces(Produto produto) {
        System.out.println("##### Mesma lambda rodando em interfaces diferentes #####");

        System.out.println("Executa método sem retorno");
        executeString((String value) -> {
                value = value.toUpperCase();
                value.trim();
            }, produto.getNome());
        System.out.println();

        System.out.println("Executa método com retorno");
        String output = executeString((String value) -> {
                value = value.toUpperCase();
                return value.trim();
            }, produto.getNome());
        System.out.println("Retorno lambda = " + output);
        System.out.println();
    }

    private void executeString(StringProcess lambda, String value) {
        lambda.apply(value);
    }

    private String executeString(StringProcessWithReturn lambda, String value) {
        return lambda.apply(value);
    }
}
