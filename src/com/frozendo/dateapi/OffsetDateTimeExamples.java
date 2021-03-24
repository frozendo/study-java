package com.frozendo.zonedDateTimeapi;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

public class OffsetDateTimeExamples {

    public static void main(String[] args) {

        ZoneOffset zoneOffset = ZoneOffset.of("-05:00");
        OffsetDateTime chigagoTime = OffsetDateTime.now(zoneOffset);
        System.out.println("Datetime now in Chicago = " + chigagoTime);
        System.out.println("Same instant offset = " + chigagoTime.withOffsetSameInstant(ZoneOffset.of("+11:00")));
        System.out.println("Same local offset = " + chigagoTime.withOffsetSameLocal(ZoneOffset.of("-08:00")));
        System.out.println();

        //Get Paris Time and use in common operations
        ZoneOffset parisOffset = ZoneOffset.of("+01:00");
        OffsetDateTime parisTime = OffsetDateTime.now(parisOffset);
        System.out.println("Datetime now in Chicago = " + parisTime);

        System.out.println("##### ZonedDateTime get examples #####");
        System.out.println("Day of month = " + parisTime.getDayOfMonth());
        System.out.println("Day of week = " + parisTime.getDayOfWeek());
        System.out.println("Day of year = " + parisTime.getDayOfYear());
        System.out.println();

        System.out.println("##### Defining new parisTime value #####");
        System.out.println("Set parisTime to hundredth day of the year = " + parisTime.withDayOfYear(100));
        System.out.println("Set parisTime to month number 10 (October) = " + parisTime.withMonth(10));
        System.out.println("Set parisTime to twentieth day of the month " + parisTime.withDayOfMonth(20));
        System.out.println();

        System.out.println("##### Plus parisTime values #####");
        System.out.println("Plus 2 weeks and 1 year = " + parisTime.plusWeeks(2).plusYears(1));
        System.out.println("Plus 2 months = " + parisTime.plusMonths(2));
        System.out.println("Plus 20 days = " + parisTime.plusDays(20));
        System.out.println();

        System.out.println("##### Minus parisTime values #####");
        System.out.println("Minus 2 weeks and 1 year = " + parisTime.minusWeeks(2).minusYears(1));
        System.out.println("Minus 2 months = " + parisTime.minusMonths(2));
        System.out.println("Minus 20 days = " + parisTime.minusDays(20));
        System.out.println();

        System.out.println("##### Temporal Adjusters examples #####");
        System.out.println("Get last day of the month = " + parisTime.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + parisTime.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + parisTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + parisTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));

    }

}
