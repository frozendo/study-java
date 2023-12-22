package com.frozendo.java8.dateapi.localdate;

import java.time.LocalDate;

public class LocalDateCreate {
    public static void main(String[] args) {
        System.out.println("LocalDate now = " + LocalDate.now());
        System.out.println("LocalDate of = " + LocalDate.of(2020, 12, 31));
        System.out.println("LocalDate parse = " + LocalDate.parse("2021-03-12"));
    }
}
