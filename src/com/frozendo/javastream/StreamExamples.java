package com.frozendo.javastream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        StreamExamples execute = new StreamExamples();

        List<String> list = Arrays.asList("Java", "Go", "Javascript", "C#", "Python",
                "C", "C++", "Rust", "Ruby", "Cobol", "Elixir", "Lua", "F#");

        execute.sortAndPrint(list);
        execute.filterAndFind(list);
        execute.matchExamples(list);
        execute.collectionCalculate(list);
        execute.mapExample(list);
        execute.flatMapExample(list);

    }

    private void sortAndPrint(List<String> fruits) {
        System.out.println("##### Ordering in alphabetic order and limit in 5 items #####");
        fruits.stream()
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Ordering by work length and remove duplication #####");
        fruits.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .distinct()
                .forEach(f -> {
                    String upper = f.toUpperCase();
                    System.out.println(upper);
                });

        System.out.println();
    }

    private void filterAndFind(List<String> fruits) {
        System.out.println("##### Filter words that start with 'C' and get the first #####");
        Optional<String> first = fruits.stream()
                .filter(p -> p.startsWith("C"))
                .findFirst();
        System.out.println(first.orElse(""));

        System.out.println();

        System.out.println("##### Filter words that start with 'C' and get any #####");
        Optional<String> any = fruits.stream()
                .filter(p -> p.startsWith("C"))
                .sorted(Comparator.comparingInt(String::length))
                .findAny();
        System.out.println(any.orElse(""));

        System.out.println();
    }

    private void matchExamples(List<String> fruits) {
        System.out.println("##### Any Match #####");
        boolean anyTrue = fruits.stream()
                .anyMatch(p -> p.startsWith("J"));
        System.out.println("AnyMatch should be true = " + anyTrue);
        boolean anyFalse = fruits.stream()
                .anyMatch(p -> p.startsWith("X"));
        System.out.println("AnyMatch should be false = " + anyFalse);

        System.out.println();

        System.out.println("##### All Match #####");
        boolean allTrue = fruits.stream()
                .allMatch(Objects::nonNull);
        System.out.println("AllMatch should be true = " + allTrue);
        boolean allFalse = fruits.stream()
                .allMatch(p -> p.equals("Java"));
        System.out.println("AllMatch should be false = " + allFalse);

        System.out.println();

        System.out.println("##### None Match #####");
        boolean noneTrue = fruits.stream()
                .noneMatch(p -> p.startsWith("Kafka"));
        System.out.println("NoneMatch should be true = " + noneTrue);
        boolean noneFalse = fruits.stream()
                .noneMatch(p -> p.equals("Java"));
        System.out.println("NoneMatch should be false = " + noneFalse);

        System.out.println();
    }

    private void collectionCalculate(List<String> fruits) {
        System.out.println("##### Filter words that start with 'C' and count #####");
        long count = fruits.stream()
                .filter(p -> p.startsWith("C"))
                .count();
        System.out.println(count);

        System.out.println();

        System.out.println("##### Get the biggest word that start with 'C' #####");
        Optional<String> max = fruits.stream()
                .filter(p -> p.startsWith("C"))
                .max(Comparator.comparingInt(String::length));
        System.out.println(max.orElse(""));

        System.out.println();

        System.out.println("##### Get the smallest word that start with 'C' #####");
        Optional<String> min = fruits.stream()
                .filter(p -> p.startsWith("C"))
                .min(Comparator.comparingInt(String::length));
        System.out.println(min.orElse(""));

        System.out.println();
    }

    private void mapExample(List<String> fruits) {
        System.out.println("##### Map to string length - change from Stream<String> to Stream<Integer> #####");
        fruits.stream()
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Map to bytes - change from Stream<String> to Stream<byte[]> #####");
        fruits.stream()
                .map(String::getBytes)
                .forEach(System.out::println);

        System.out.println();

    }

    private void flatMapExample(List<String> fruits) {
        List<String> vegetables = Arrays.asList("Rabbit", "Kafka", "JMS", "ActiveMQ", "SQS");

        System.out.println("##### Flatmap to string stream - change from Stream<List<String>> to Stream<String> #####");
        Stream.of(fruits, vegetables)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("##### Flatmap to intStream - change from Stream<List<String>> to IntStream #####");
        Stream.of(fruits, vegetables)
                .flatMapToInt(f -> IntStream.of(f.size()))
                .forEach(System.out::println);

        System.out.println();

    }

}
