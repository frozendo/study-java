package com.frozendo.java8.dateapi.offsetdatetime;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimePlusAndMinusValues {

    public static void main(String[] args) {
        ZoneOffset parisOffset = ZoneOffset.of("+01:00");
        OffsetDateTime parisTime = OffsetDateTime.now(parisOffset);

        System.out.println("Plus 2 weeks and 1 year = " + parisTime.plusWeeks(2).plusYears(1));
        System.out.println("Plus 2 months = " + parisTime.plusMonths(2));
        System.out.println("Plus 20 days = " + parisTime.plusDays(20));

        System.out.println();

        System.out.println("Minus 2 weeks and 1 year = " + parisTime.minusWeeks(2).minusYears(1));
        System.out.println("Minus 2 months = " + parisTime.minusMonths(2));
        System.out.println("Minus 20 days = " + parisTime.minusDays(20));
    }

}
