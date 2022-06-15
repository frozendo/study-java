package com.frozendo.reduction;

import com.frozendo.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExamples {

    public static void main(String[] args) {
        CollectExamples execute = new CollectExamples();
        List<Product> products = Product.buildList();

        System.out.println("##### Collector with three parameter #####");
        execute.collectorsSimple(products);
        execute.collectorsSimpleWithMethodReference(products);
        System.out.println();

        System.out.println("##### Pre defined collectors #####");
        execute.preDefineCollectorsToList(products);
        execute.preDefineCollectorsToSet(products);
        execute.preDefineCollectorsToCollection(products);
        execute.preDefineCollectorsToMap(products);
        execute.preDefineCollectorsJoining();
        System.out.println();

        System.out.println("##### Calculations collectors #####");
        execute.averageCollectors(products);
        execute.summingCollectors(products);
        execute.countingCollectors(products);
        execute.maxByCollectors(products);
        execute.minByCollectors(products);
        execute.summarizingCollectors(products);
        System.out.println();
    }

    public void collectorsSimple(List<Product> products) {
        System.out.println("Collector with lambda function");
        List<String> list = products.stream()
                .collect(
                        () -> new ArrayList<>(),
                        (l, i) -> l.add(i.getName()),
                        (l1, l2) -> l1.addAll(l2)
                );

        System.out.println("list result size = " + list.size());
    }

    public void collectorsSimpleWithMethodReference(List<Product> products) {
        System.out.println("Collector with method reference");
        List<Product> list = products.stream()
                .collect(ArrayList::new,ArrayList::add, ArrayList::addAll);

        System.out.println("list result size = " + list.size());
    }

    public void preDefineCollectorsToList(List<Product> products) {
        System.out.println("toList collector");
        List<Double> list = products.stream()
                .map(i -> i.getPrice())
                .collect(Collectors.toList());

        System.out.println("list result size = " + list.size());
    }

    public void preDefineCollectorsToSet(List<Product> products) {
        System.out.println("toSet collector");
        Set<String> set = products.stream()
                .map(i -> i.getName())
                .collect(Collectors.toSet());

        System.out.println("set result size = " + set.size());
    }

    public void preDefineCollectorsToCollection(List<Product> products) {
        System.out.println("toCollection collector - create a LinkedHashSet and a LinkedList");
        Set<Double> set = products.stream()
                .map(i -> i.getPrice())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<String> list = products.stream()
                .map(i -> i.getName())
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("set result size = " + set.size());
        System.out.println("list result size = " + list.size());
    }

    public void preDefineCollectorsToMap(List<Product> products) {
        System.out.println("simple toMap collector");
        Map<Double, String> map = products.stream()
                .collect(Collectors.toMap(
                        Product::getPrice, Product::getName
                ));

        System.out.println("map result size = " + map.size());

        System.out.println("toMap collector - with merge function");
        Map<Long, Double> otherMap = products.stream()
                .collect(Collectors.toMap(
                        Product::getId,
                        Product::getPrice,
                        (existing, replacement) -> {
                            if (existing > replacement) {
                                return existing;
                            }
                            return replacement;
                        },
                        LinkedHashMap::new
                ));

        System.out.println("map result size = " + otherMap.size());
    }

    public void preDefineCollectorsJoining() {
        System.out.println("joining collector");
        String result = Stream.of("Example", "of", "using", "exists", "collectors")
                .collect(Collectors.joining());

        System.out.println("joining result = " + result);
    }

    public void averageCollectors(List<Product> products) {
        Double collect = products.stream()
                .collect(Collectors.averagingLong(
                        Product::getId
                ));

        System.out.println("averageInt result = " + collect);
    }

    public void summingCollectors(List<Product> products) {
        Double collect = products.stream()
                .collect(Collectors.summingDouble(
                        Product::getPrice
                ));

        System.out.println("summingDouble result = " + collect);
    }

    public void countingCollectors(List<Product> products) {
        Long collect = products.stream()
                .collect(Collectors.counting());

        System.out.println("counting result = " + collect);
    }

    public void maxByCollectors(List<Product> products) {
        Optional<Product> collect = products.stream()
                .collect(Collectors.maxBy(Comparator.comparing(
                        (value) -> value.getPrice()
                )));

        System.out.println("maxBy result = " + collect.get());
    }

    public void minByCollectors(List<Product> products) {
        Optional<Product> collect = products.stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        (value) -> value.getPrice()
                )));

        System.out.println("minBy result = " + collect.get());
    }

    public void summarizingCollectors(List<Product> products) {
        LongSummaryStatistics collect = products.stream()
                .collect(Collectors.summarizingLong(
                        value -> value.getId()
                ));

        System.out.println("summarizingLong result = " + collect);
    }

}
