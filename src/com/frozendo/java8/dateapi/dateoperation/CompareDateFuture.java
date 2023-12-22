package com.frozendo.java8.dateapi.dateoperation;

import java.time.LocalDate;

public class CompareDateFuture {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate dateInFuture = now.plusYears(2).plusDays(20);

        System.out.println("Date future isAfter = " + now.isAfter(dateInFuture));
        System.out.println("Date future isBefore = " + now.isBefore(dateInFuture));
        System.out.println("Date future isEqual = " + now.isEqual(dateInFuture));
    }

}
