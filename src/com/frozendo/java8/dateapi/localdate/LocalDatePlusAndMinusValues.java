package com.frozendo.java8.dateapi.localdate;

import java.time.LocalDate;

public class LocalDatePlusAndMinusValues {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        System.out.println("Plus 2 weeks and 1 year = " + date.plusWeeks(2).plusYears(1));
        System.out.println("Plus 2 months = " + date.plusMonths(2));
        System.out.println("Plus 20 days = " + date.plusDays(20));

        System.out.println();

        System.out.println("Minus 2 weeks and 1 year = " + date.minusWeeks(2).minusYears(1));
        System.out.println("Minus 2 months = " + date.minusMonths(2));
        System.out.println("Minus 20 days = " + date.minusDays(20));
    }

}
