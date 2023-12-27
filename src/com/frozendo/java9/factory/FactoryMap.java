package com.frozendo.java9.factory;

import java.util.Map;

public class FactoryMap {

    public static void main(String[] args) {
        factoryCommonMap();
        factoryEntryMap();
        factoryMapWithDuplicateElements();
        factoryMapAddNewElement();
        factoryMapWithNullValue();
    }

    private static void factoryCommonMap() {
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

    private static void factoryEntryMap() {
        Map<String, Integer> entryMap = Map.ofEntries(
                Map.entry("key1", 1),
                Map.entry("key2", 2),
                Map.entry("key3", 3)
        );
        System.out.println("map create with Map.ofEntries = " + entryMap);
        System.out.println("Type of map " + entryMap.getClass());
        System.out.println("Check elements order (each time can be a different order)");
        entryMap.entrySet().forEach(entry -> {
            System.out.println("entry key = " + entry.getKey());
            System.out.println("entry value = " + entry.getValue());
        });
        System.out.println();
    }

    private static void factoryMapWithDuplicateElements() {
        try {
            Map.of("key1", "value1", "key2", "value2",
                    "key3", "value3", "key1", "value4");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error when add duplicate keys in map");
            System.out.println("message error = " + ex.getMessage());
        }
        System.out.println();
    }

    private static void factoryMapAddNewElement() {
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2", "key3", "value3");
        System.out.println("map create = " + map);
        try {
            map.put("key4", "value4");
        } catch (UnsupportedOperationException ex) {
            System.out.println("UnsupportedOperationException when try to add new element");
        }
        System.out.println();
    }

    private static void factoryMapWithNullValue() {
        try {
            Map.of("key1", "value1", "key2", "value2",
                    "key3", "value3", null, null);
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException when try to create collection with a null value");
        }
        System.out.println();
    }

}
