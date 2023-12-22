package com.frozendo.java8.dateapi.localdatetime;

import java.time.LocalDateTime;

public class LocalDateTimePlusAndMinusValues {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Plus 2 weeks and 1 year = " + dateTime.plusWeeks(2).plusYears(1));
        System.out.println("Plus 9 hours and 100 seconds = " + dateTime.plusHours(9).plusSeconds(100));
        System.out.println("Plus 10 months and 20 minutes = " + dateTime.plusMonths(10).plusMinutes(20));

        System.out.println();

        System.out.println("Minus 2 weeks and 1 year = " + dateTime.minusWeeks(2).minusYears(1));
        System.out.println("Minus 9 hours and 100 seconds = " + dateTime.minusHours(9).minusSeconds(100));
        System.out.println("Minus 10 months and 20 minutes = " + dateTime.minusMonths(10).minusMinutes(20));
    }

}
