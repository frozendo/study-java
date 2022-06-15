package com.frozendo.reduction;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class ReduceExamples {

    public static void main(String[] args) {

        ReduceExamples execute = new ReduceExamples();
        List<Product> list = Product.buildList();

        System.out.println("#### Simple reduce examples ######");
        execute.sumNumbersWithReduce(list);
        execute.concatStringWithReduce(list);
        System.out.println();

        System.out.println("#### Reduce with identity examples ######");
        execute.sumNumbersWithInitialValue(list);
        execute.concatStringWithInitialValue(list);
        System.out.println();

        System.out.println("#### Reduce with accumulator e combiner ######");
        execute.concatNumbersWithReduce(list);
        execute.sumStringLengthWithReduce(list);
    }

    public void sumNumbersWithReduce(List<Product> list) {
        OptionalDouble total = list.stream()
                .mapToDouble(Product::getPrice)
                .reduce((sum, value) -> sum + value);
        System.out.println("Reduce sum result = " + total.getAsDouble());
    }

    public void concatStringWithReduce(List<Product> list) {
        Optional<String> result = list.stream()
                .map(i -> i.getName())
                .reduce((word, value) -> word.concat(" ").concat(value));

        System.out.println("Reduce concat result = " + result.get());
    }

    public void sumNumbersWithInitialValue(List<Product> list) {
        Double total = list.stream()
                .map(i -> i.getPrice())
                .reduce(100.0, (sum, value) -> sum + value);
        System.out.println("Sum initiate with 100 = " + total);
    }

    public void concatStringWithInitialValue(List<Product> list) {
        String result = list.stream()
                .map(i -> i.getName())
                .reduce("Concat with initiate value = ", (word, value) -> word.concat(" ").concat(value));

        System.out.println(result);
    }

    public void concatNumbersWithReduce(List<Product> list) {
        String result = list.stream()
                .map(i -> i.getId())
                .reduce("Concat numbers in a string = ",
                        (word, value) -> word.concat(value.toString()),
                        (value1, value2) -> value1.concat(value2));

        System.out.println(result);
    }

    public void sumStringLengthWithReduce(List<Product> list) {
        Integer result = list.stream()
                .map(i -> i.getName())
                .reduce(0,
                        (sum, value) -> sum + value.length(),
                        (value1, value2) -> value1 + value2);

        System.out.println("Total string length = " + result);
    }

}
