package com.frozendo.java9.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableListPreJava9 {

    public static void main(String[] args) {
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
    }

}
