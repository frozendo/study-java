package com.frozendo.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoriesListExamples {

    public static void main(String[] args) {
        FactoriesListExamples execute = new FactoriesListExamples();

        execute.arrayListFactoryPreJava9();
        execute.createUnmodifiableListPreJava9();

        execute.factoryListExample();
        execute.factorySetExample();
        execute.factoryMapExample();
        execute.factoryMapEntryExample();

        execute.factoryListWithDuplicateElements();
        execute.factorySetWithDuplicateElements();
        execute.factoryMapWithDuplicateElements();

        execute.factoryListAddNewElement();
        execute.factorySetAddNewElement();
        execute.factoryMapAddNewElement();

        execute.factoryListWithNullValue();
        execute.factorySetWithNullValue();
        execute.factoryMapWithNullValue();

        execute.factoryValueBased();
    }

    private void arrayListFactoryPreJava9() {
        System.out.println("##### Examples pre Java 9 #####");
        List<String> list = Arrays.asList("value 1", "value 2", "value 3");

        System.out.println("list create with Arrays.asList = " + list);
    }

    private void createUnmodifiableListPreJava9() {
        List<String> list = new ArrayList<>();
        list.add("value 1");
        list.add("value 2");
        list.add("value 3");

        List<String> unmodifiable = Collections.unmodifiableList(list);

        System.out.println("Unmodifiable List = " + unmodifiable);

        System.out.println("Try to change the list and catch the error");

        try {
            unmodifiable.add("new value");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Error when try to change unmodifiable list");
        }
        System.out.println();


    }

    private void factoryListExample() {
        System.out.println("##### List.of example #####");
        List<String> list = List.of("value1", "value2", "value3");
        System.out.println("list create with List.of = " + list);
        System.out.println("Type of list " + list.getClass());
        System.out.println("Check elements order, that always is the same");
        list.forEach(System.out::println);
        System.out.println();
    }

    private void factorySetExample() {
        System.out.println("##### Set.of example #####");
        Set<String> set = Set.of("value1", "value2", "value3");
        System.out.println("set create with Set.of = " + set);
        System.out.println("Type of set " + set.getClass());
        System.out.println("Check elements order (each time can be a different order)");
        set.forEach(System.out::println);
        System.out.println();
    }

    private void factoryMapExample() {
        System.out.println("##### Map.of example #####");
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2", "key3", "value3");
        System.out.println("map create with Map.of = " + map);
        System.out.println("Type of map " + map.getClass());
        System.out.println("Check elements order (each time can be a different order)");
        map.forEach((key, value) -> {
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });
        System.out.println();
    }

    private void factoryMapEntryExample() {
        System.out.println("##### Map.ofEntries example #####");
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("key1", 1),
                Map.entry("key2", 2),
                Map.entry("key3", 3)
        );
        System.out.println("map create with Map.ofEntries = " + map);
        System.out.println("Type of map " + map.getClass());
        System.out.println("Check elements order (each time can be a different order)");
        map.entrySet().forEach(entry -> {
            System.out.println("entry key = " + entry.getKey());
            System.out.println("entry value = " + entry.getValue());
        });
        System.out.println();
    }

    private void factoryListWithDuplicateElements() {
        System.out.println("##### Duplicate elements in list #####");
        List<Integer> list = List.of(1, 2, 3, 4, 5, 1);
        System.out.println("list with duplicate elements = " + list);
        System.out.println();
    }

    private void factorySetWithDuplicateElements() {
        System.out.println("##### Duplicate elements in set #####");
        try {
            Set.of(1, 2, 3, 4, 5, 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error when add duplicate elements in set");
            System.out.println("message error = " + ex.getMessage());
        }
        System.out.println();
    }

    private void factoryMapWithDuplicateElements() {
        System.out.println("##### Duplicate key in map #####");
        try {
            Map.of("key1", "value1", "key2", "value2",
                    "key3", "value3", "key1", "value4");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error when add duplicate keys in map");
            System.out.println("message error = " + ex.getMessage());
        }
        System.out.println();
    }

    private void factoryListAddNewElement() {
        System.out.println("##### Try to add a new element in list after create #####");
        List<String> list = List.of("value1", "value2", "value3");
        System.out.println("list create = " + list);
        try {
            list.add("value4");
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException when try to add new element");
        }
        System.out.println();
    }

    private void factorySetAddNewElement() {
        System.out.println("##### Try to add a new element in set after create #####");
        Set<String> set = Set.of("value1", "value2", "value3");
        System.out.println("set create = " + set);
        try {
            set.add("value4");
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException when try to add new element");
        }
        System.out.println();
    }

    private void factoryMapAddNewElement() {
        System.out.println("##### Try to add a new element in map after create #####");
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2", "key3", "value3");
        System.out.println("map create = " + map);
        try {
            map.put("key4", "value4");
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException when try to add new element");
        }
        System.out.println();
    }

    private void factoryListWithNullValue() {
        System.out.println("##### Try to add a null value in list #####");
        try {
            List.of("value1", "value2", "value3", null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException when try to create collection with a null value");
        }
        System.out.println();
    }

    private void factorySetWithNullValue() {
        System.out.println("##### Try to add a null value in set #####");
        try {
            Set.of("value1", "value2", "value3", null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException when try to create collection with a null value");
        }
        System.out.println();
    }

    private void factoryMapWithNullValue() {
        System.out.println("##### Try to add a null value  in map #####");
        try {
            Map.of("key1", "value1", "key2", "value2",
                    "key3", "value3", null, null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException when try to create collection with a null value");
        }
        System.out.println();
    }

    private void factoryValueBased() {
        List<Integer> list1 = List.of(0, 5, 10);
        List<Integer> list2 = List.of(0, 5, 10);

        if (list1 == list2) {
            System.out.println("The reference of list1 and list2 are the same");
        } else {
            System.out.println("The reference of list1 and list2 are not the same");
        }

    }

}
