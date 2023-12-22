package com.frozendo.java8.dateapi.dateoperation;

import java.time.LocalDate;

public class CompareDatePast {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate dateInPast = LocalDate.of(2020, 3, 23);

        System.out.println("Date past isAfter = " + now.isAfter(dateInPast));
        System.out.println("Date past isBefore = " + now.isBefore(dateInPast));
        System.out.println("Date past isEqual = " + now.isEqual(dateInPast));
    }

}
