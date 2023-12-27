package com.frozendo.java9.factory;

import java.util.List;

public class FactoryValueBased {

    public static void main(String[] args) {
        List<Integer> list1 = List.of(0, 5, 10);
        List<Integer> list2 = List.of(0, 5, 10);

        if (list1 == list2) {
            System.out.println("The reference of list1 and list2 are the same");
        } else {
            System.out.println("The reference of list1 and list2 are not the same");
        }
    }

}
