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
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectExamples {

    public static void main(String[] args) {
        CollectExamples collectExamples = new CollectExamples();
        List<Product> products = Product.buildList();

        System.out.println("##### Collector with three parameter #####");
        collectExamples.collectorsSimple(products);
        collectExamples.collectorsSimpleWithMethodReference();
        System.out.println();

        System.out.println("##### Pre existing collectors #####");
        collectExamples.preDefineCollectorsToList(products);
        collectExamples.preDefineCollectorsToSet(products);
        collectExamples.preDefineCollectorsToCollection(products);
        collectExamples.preDefineCollectorsToMap(products);
        collectExamples.preDefineCollectorsJoining();
        System.out.println();

        System.out.println("##### Calculations collectors #####");
        collectExamples.averageCollectors(products);
        collectExamples.summingCollectors(products);
        collectExamples.countingCollectors(products);
        collectExamples.maxByCollectors(products);
        collectExamples.minByCollectors(products);
        collectExamples.summarizingCollectors(products);
        System.out.println();
    }

    public void collectorsSimple(List<Product> products) {
        List<String> list = products.stream()
                .collect(
                        () -> new ArrayList<>(),
                        (l, i) -> l.add(i.getNome()),
                        (l1, l2) -> l1.addAll(l2)
                );

        System.out.println("list result size = " + list.size());
    }

    public void collectorsSimpleWithMethodReference() {
        List<Integer> list = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .collect(ArrayList::new,ArrayList::add, ArrayList::addAll);

        System.out.println("list result size = " + list.size());
    }

    public void preDefineCollectorsToList(List<Product> products) {
        List<Double> list = products.stream()
                .map(i -> i.getPreco())
                .collect(Collectors.toList());

        System.out.println("list result size = " + list.size());
    }

    public void preDefineCollectorsToSet(List<Product> products) {
        Set<String> set = products.stream()
                .map(i -> i.getNome())
                .collect(Collectors.toSet());

        System.out.println("set result size = " + set.size());
    }

    public void preDefineCollectorsToCollection(List<Product> products) {
        Set<Double> set = products.stream()
                .map(i -> i.getPreco())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        List<String> list = products.stream()
                .map(i -> i.getNome())
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("set result size = " + set.size());
        System.out.println("list result size = " + list.size());
    }

    public void preDefineCollectorsToMap(List<Product> products) {
        Map<Double, String> map = products.stream()
                .collect(Collectors.toMap(
                        Product::getPreco, Product::getNome
                ));

        System.out.println("map result size = " + map.size());

        Map<Long, Double> otherMap = products.stream()
                .collect(Collectors.toMap(
                        Product::getId,
                        Product::getPreco,
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
                        Product::getPreco
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
                        (value) -> value.getPreco()
                )));

        System.out.println("maxBy result = " + collect.get());
    }

    public void minByCollectors(List<Product> products) {
        Optional<Product> collect = products.stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        (value) -> value.getPreco()
                )));

        System.out.println("maxBy result = " + collect.get());
    }

    public void summarizingCollectors(List<Product> products) {
        LongSummaryStatistics collect = products.stream()
                .collect(Collectors.summarizingLong(
                        value -> value.getId()
                ));

        System.out.println("summarizingLong result = " + collect);
    }

}
