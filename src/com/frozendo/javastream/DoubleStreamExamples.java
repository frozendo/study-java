package com.frozendo.javastream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class DoubleStreamExamples {

    public static void main(String[] args) {

        DoubleStreamExamples example = new DoubleStreamExamples();

        double[] numbers = { 22.2, 72.5, 1.9, 99.10, 49.5, 22.9, 101, 33.54, 87.99, 110.12, 8.8, 7.87, 15.3, 2.44, 99.10, 101 };

        example.sortAndPrint(numbers);
        example.filterAndFind(numbers);
        example.matchExamples(numbers);
        example.findAndCalculate(numbers);
        example.mapExample(numbers);

    }

    private void sortAndPrint(double[] numbers) {
        System.out.println("##### Ordem - limitando em 5 #####");
        DoubleStream.of(numbers)
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Ordena - remove duplicado - multiplica por 2 #####");
        DoubleStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Double multi = f * 2;
                    System.out.println(multi);
                });

        System.out.println();
    }

    public void filterAndFind(double[] numbers) {
        System.out.println("##### Filtra numeros menor que 50 e recupera o primeiro #####");
        OptionalDouble first = DoubleStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("##### Filtra numeros maior que 80 e recupera o primeiro encontrado #####");
        OptionalDouble any = DoubleStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));

        System.out.println();
    }

    private void matchExamples(double[] numbers) {
        System.out.println("##### Any Match #####");
        boolean anyTrue = DoubleStream.of(numbers)
                .anyMatch(p -> p > 2);
        System.out.println("AnyMatch should be true = " + anyTrue);
        boolean anyFalse = DoubleStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);

        System.out.println();

        System.out.println("##### All Match #####");
        boolean allTrue = DoubleStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);
        boolean allFalse = DoubleStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);

        System.out.println();

        System.out.println("##### None Match #####");
        boolean noneTrue = DoubleStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);
        boolean noneFalse = DoubleStream.of(numbers)
                .noneMatch(p -> p > 2);
        System.out.println("NoneMatch should be false = " + noneFalse);

        System.out.println();
    }

    private void findAndCalculate(double[] numbers) {
        System.out.println("##### Filtra numeros menor que 5 e conta o total #####");
        long count = DoubleStream.of(numbers)
                .filter(p -> p < 5)
                .count();
        System.out.println(count);

        System.out.println();

        System.out.println("##### Pega a maior numero maior que 90 #####");
        OptionalDouble max = DoubleStream.of(numbers)
                .filter(p -> p > 90)
                .max();
        System.out.println(max.orElse(0));

        System.out.println();

        System.out.println("##### Pega o menor numero maior que 90 #####");
        OptionalDouble min = DoubleStream.of(numbers)
                .filter(p -> p > 90)
                .min();
        System.out.println(min.orElse(0));

        System.out.println();

        System.out.println("##### Soma todos os numeros da lista #####");
        double sum = DoubleStream.of(numbers)
                .sum();
        System.out.println(sum);

        System.out.println();

        System.out.println("##### Calcula a média excluindo os 5 primeiros numeros da lista #####");
        OptionalDouble average = DoubleStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));

        System.out.println();
    }

    private void mapExample(double[] numbers) {
        System.out.println("##### Map transformando pra int #####");
        DoubleStream.of(numbers)
                .mapToInt(m -> Double.valueOf(m).intValue())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Map - multiplicando por 3 #####");
        DoubleStream.of(numbers)
                .map(m -> m * 3)
                .forEach(System.out::println);

        System.out.println();

    }
}
