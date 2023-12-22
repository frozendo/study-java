package com.frozendo.java8.dateapi.offsetdatetime;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

public class OffsetDateTimeTemporalAdjusters {

    public static void main(String[] args) {
        ZoneOffset parisOffset = ZoneOffset.of("+01:00");
        OffsetDateTime parisTime = OffsetDateTime.now(parisOffset);

        System.out.println("Get last day of the month = " + parisTime.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + parisTime.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + parisTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + parisTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }

}
