package com.frozendo.javastream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        StreamExamples examples = new StreamExamples();

        List<String> fruits = Arrays.asList("maçã", "banana", "goiaba", "laranja", "tangerina",
                "abacaxi", "kiwi", "morango", "melancia", "maçã", "goiaba", "kiwi", "limão");

        examples.sortAndPrint(fruits);
        examples.filterAndFind(fruits);
        examples.matchExamples(fruits);
        examples.findAndCalc(fruits);
        examples.mapExample(fruits);
        examples.flatMapExample(fruits);

    }

    private void sortAndPrint(List<String> fruits) {
        System.out.println("##### Ordem alfabetica - limitando em 5 #####");
        fruits.stream()
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Ordena pelo tamanho da palavra - remove duplicado #####");
        fruits.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .distinct()
                .forEach(f -> {
                    String upper = f.toUpperCase();
                    System.out.println(upper);
                });

        System.out.println();
    }

    public void filterAndFind(List<String> fruits) {
        System.out.println("##### Filtra palavras e recupera a primeira #####");
        Optional<String> first = fruits.stream()
                .filter(p -> p.startsWith("l"))
                .findFirst();
        System.out.println(first.orElse(""));

        System.out.println();

        System.out.println("##### Filtra palavras e recupera a primeira encontrada #####");
        Optional<String> any = fruits.stream()
                .filter(p -> p.startsWith("l"))
                .sorted(Comparator.comparingInt(String::length))
                .findAny();
        System.out.println(any.orElse(""));

        System.out.println();
    }

    private void matchExamples(List<String> fruits) {
        System.out.println("##### Any Match #####");
        boolean anyTrue = fruits.stream()
                .anyMatch(p -> p.startsWith("m"));
        System.out.println("AnyMatch should be true = " + anyTrue);
        boolean anyFalse = fruits.stream()
                .anyMatch(p -> p.startsWith("s"));
        System.out.println("AnyMatch should be false = " + anyFalse);

        System.out.println();

        System.out.println("##### All Match #####");
        boolean allTrue = fruits.stream()
                .allMatch(p -> p != null);
        System.out.println("AllMatch should be true = " + allTrue);
        boolean allFalse = fruits.stream()
                .allMatch(p -> p.equals("laranja"));
        System.out.println("AllMatch should be false = " + allFalse);

        System.out.println();

        System.out.println("##### None Match #####");
        boolean noneTrue = fruits.stream()
                .noneMatch(p -> p.startsWith("melão"));
        System.out.println("NoneMatch should be true = " + noneTrue);
        boolean noneFalse = fruits.stream()
                .noneMatch(p -> p.equals("laranja"));
        System.out.println("NoneMatch should be false = " + noneFalse);

        System.out.println();
    }

    private void findAndCalc(List<String> fruits) {
        System.out.println("##### Filtra palavras e calcula o total #####");
        long count = fruits.stream()
                .filter(p -> p.startsWith("m"))
                .count();
        System.out.println(count);

        System.out.println();

        System.out.println("##### Pega a maior palavra da lista #####");
        Optional<String> max = fruits.stream()
                .filter(p -> p.startsWith("m"))
                .max(Comparator.comparingInt(String::length));
        System.out.println(max.orElse(""));

        System.out.println();

        System.out.println("##### Pega a menor palavra da lista #####");
        Optional<String> min = fruits.stream()
                .filter(p -> p.startsWith("m"))
                .min(Comparator.comparingInt(String::length));
        System.out.println(min.orElse(""));

        System.out.println();
    }

    private void mapExample(List<String> fruits) {
        System.out.println("##### Map to string length - muda de Stream<String> para Stream<Integer> #####");
        fruits.stream()
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Map to bytes - muda de Stream<String> para Stream<byte[]> #####");
        fruits.stream()
                .map(String::getBytes)
                .forEach(System.out::println);

        System.out.println();

    }

    private void flatMapExample(List<String> fruits) {
        List<String> vegetables = Arrays.asList("beterraba", "cenoura", "batata", "abobrinha", "pepino");

        System.out.println("##### Flatmap to string stream - muda de Stream<List<String>> para Stream<String> #####");
        Stream.of(fruits, vegetables)
                .flatMap(f -> f.stream())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Flatmap to intStream - muda de Stream<List<String>> para IntStream #####");
        Stream.of(fruits, vegetables)
                .flatMapToInt(f -> IntStream.of(f.size()))
                .forEach(System.out::println);

        System.out.println();

    }

}
