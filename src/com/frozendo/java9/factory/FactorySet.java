package com.frozendo.java9.factory;

import java.util.Set;

public class FactorySet {

    public static void main(String[] args) {
        factoryCommonSet();
        factorySetWithDuplicateElements();
        factorySetAddNewElement();
        factorySetWithNullValue();
    }

    private static void factoryCommonSet() {
        Set<String> set = Set.of("value1", "value2", "value3");
        System.out.println("set create with Set.of = " + set);
        System.out.println("Type of set " + set.getClass());
        System.out.println("Check elements order (each time can be a different order)");
        set.forEach(System.out::println);
        System.out.println();
    }

    private static void factorySetWithDuplicateElements() {
        try {
            Set.of(1, 2, 3, 4, 5, 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error when add duplicate elements in set");
            System.out.println("message error = " + ex.getMessage());
        }
        System.out.println();
    }

    private static void factorySetAddNewElement() {
        Set<String> set = Set.of("value1", "value2", "value3");
        System.out.println("set create = " + set);
        try {
            set.add("value4");
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException when try to add new element");
        }
        System.out.println();
    }

    private static void factorySetWithNullValue() {
        try {
            Set.of("value1", "value2", "value3", null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException when try to create collection with a null value");
        }
        System.out.println();
    }

}
