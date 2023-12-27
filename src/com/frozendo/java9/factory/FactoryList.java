package com.frozendo.java9.factory;

import java.util.List;

public class FactoryList {

    public static void main(String[] args) {
        commonFactoryList();
        factoryListWithDuplicateElements();
        factoryListAddNewElement();
        factoryListWithNullValue();
    }

    private static void commonFactoryList() {
        List<String> list = List.of("value1", "value2", "value3");
        System.out.println("list create with List.of = " + list);
        System.out.println("Type of list " + list.getClass());
        System.out.println("Check elements order, that always is the same");
        list.forEach(System.out::println);
        System.out.println();
    }

    private static void factoryListWithDuplicateElements() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 1);
        System.out.println("list with duplicate elements = " + list);
        System.out.println();
    }

    private static void factoryListAddNewElement() {
        List<String> list = List.of("value1", "value2", "value3");
        System.out.println("list create = " + list);
        try {
            list.add("value4");
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException when try to add new element");
        }
        System.out.println();
    }

    private static void factoryListWithNullValue() {
        try {
            List.of("value1", "value2", "value3", null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException when try to create collection with a null value");
        }
        System.out.println();
    }

}
