package com.frozendo.java8.dateapi.zoneddatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimePlusAndMinusValues {

    public static void main(String[] args) {
        ZoneId parisId = ZoneId.of("Europe/Paris");
        ZonedDateTime parisTime = ZonedDateTime.now(parisId);

        System.out.println("Plus 2 weeks and 1 year = " + parisTime.plusWeeks(2).plusYears(1));
        System.out.println("Plus 2 months = " + parisTime.plusMonths(2));
        System.out.println("Plus 20 days = " + parisTime.plusDays(20));

        System.out.println();

        System.out.println("Minus 2 weeks and 1 year = " + parisTime.minusWeeks(2).minusYears(1));
        System.out.println("Minus 2 months = " + parisTime.minusMonths(2));
        System.out.println("Minus 20 days = " + parisTime.minusDays(20));
    }

}
