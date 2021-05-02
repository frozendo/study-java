package com.frozendo.javastream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamExamples {

    public static void main(String[] args) {

        IntStreamExamples examples = new IntStreamExamples();

        int[] numbers = { 22, 72, 1, 99, 49, 22, 101, 33, 87, 110, 8, 7, 15, 2, 99, 101 };

        examples.sortAndPrint(numbers);
        examples.filterAndFind(numbers);
        examples.matchExamples(numbers);
        examples.findAndCalc(numbers);
        examples.mapExample(numbers);

    }

    private void sortAndPrint(int[] numbers) {
        System.out.println("##### Ordem - limitando em 5 #####");
        IntStream.of(numbers)
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Ordena - remove duplicado - multiplica por 2 #####");
        IntStream.of(numbers)
                .sorted()
                .distinct()
                .forEach(f -> {
                    Integer multi = f * 2;
                    System.out.println(multi);
                });

        System.out.println();
    }

    public void filterAndFind(int[] numbers) {
        System.out.println("##### Filtra numeros menor que 50 e recupera o primeiro #####");
        OptionalInt first = IntStream.of(numbers)
                .filter(p -> p < 50)
                .findFirst();
        System.out.println(first.orElse(0));

        System.out.println();

        System.out.println("##### Filtra numeros maior que 80 e recupera o primeiro encontrado #####");
        OptionalInt any = IntStream.of(numbers)
                .filter(p -> p > 80)
                .findAny();
        System.out.println(any.orElse(0));

        System.out.println();
    }

    private void matchExamples(int[] numbers) {
        System.out.println("##### Any Match #####");
        boolean anyTrue = IntStream.of(numbers)
                .anyMatch(p -> p % 2 == 0);
        System.out.println("AnyMatch should be true = " + anyTrue);
        boolean anyFalse = IntStream.of(numbers)
                .anyMatch(p -> p < 0);
        System.out.println("AnyMatch should be false = " + anyFalse);

        System.out.println();

        System.out.println("##### All Match #####");
        boolean allTrue = IntStream.of(numbers)
                .allMatch(p -> p >= 1);
        System.out.println("AllMatch should be true = " + allTrue);
        boolean allFalse = IntStream.of(numbers)
                .allMatch(p -> p > 299);
        System.out.println("AllMatch should be false = " + allFalse);

        System.out.println();

        System.out.println("##### None Match #####");
        boolean noneTrue = IntStream.of(numbers)
                .noneMatch(p -> p == 0);
        System.out.println("NoneMatch should be true = " + noneTrue);
        boolean noneFalse = IntStream.of(numbers)
                .noneMatch(p -> p % 2 == 0);
        System.out.println("NoneMatch should be false = " + noneFalse);

        System.out.println();
    }

    private void findAndCalc(int[] numbers) {
        System.out.println("##### Filtra numeros multiplos de 2 e conta o total #####");
        long count = IntStream.of(numbers)
                .filter(p -> p % 2 == 0)
                .count();
        System.out.println(count);

        System.out.println();

        System.out.println("##### Pega a maior numero multiplo de 3 #####");
        OptionalInt max = IntStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .max();
        System.out.println(max.orElse(0));

        System.out.println();

        System.out.println("##### Pega a menor numero multiplo de 3 #####");
        OptionalInt min = IntStream.of(numbers)
                .filter(p -> p % 3 == 0)
                .min();
        System.out.println(min.orElse(0));

        System.out.println();

        System.out.println("##### Soma todos os numeros da lista #####");
        int sum = IntStream.of(numbers)
                .sum();
        System.out.println(sum);

        System.out.println();

        System.out.println("##### Calcula a média excluindo os 5 primeiros numeros da lista #####");
        OptionalDouble average = IntStream.of(numbers)
                .skip(5)
                .average();
        System.out.println(average.orElse(0));

        System.out.println();
    }

    private void mapExample(int[] numbers) {
        System.out.println("##### Map transformando pra long #####");
        IntStream.of(numbers)
                .mapToLong(Long::valueOf)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Map - multiplicando por 3 #####");
        IntStream.of(numbers)
                .map(m -> m * 3)
                .forEach(System.out::println);

        System.out.println();

    }
}
