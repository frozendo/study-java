package com.frozendo.improvapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PreFactoryList {

    public static void main(String[] args) {
        PreFactoryList execute = new PreFactoryList();
        execute.arrayListFactory();
        execute.createUnmodifiableList();
    }

    private void arrayListFactory() {
        List<String> list = Arrays.asList("value 1", "value 2", "value 3");

        System.out.println("list create with Arrays.asList = " + list);
    }

    private void createUnmodifiableList() {
        List<String> list = new ArrayList<>();
        list.add("value 1");
        list.add("value 2");
        list.add("value 3");

        List<String> unmodifiable = Collections.unmodifiableList(list);

        System.out.println("Unmodifiable List = " + unmodifiable);

        System.out.println("### Try to change the list and catch the error ###");

        try {
            unmodifiable.add("new value");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Error when try to change unmodifiable list");
            ex.printStackTrace();
        }


    }


}
