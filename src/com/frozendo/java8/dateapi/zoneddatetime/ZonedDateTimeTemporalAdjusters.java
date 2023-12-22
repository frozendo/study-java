package com.frozendo.java8.dateapi.zoneddatetime;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class ZonedDateTimeTemporalAdjusters {

    public static void main(String[] args) {
        ZoneId parisId = ZoneId.of("Europe/Paris");
        ZonedDateTime parisTime = ZonedDateTime.now(parisId);

        System.out.println("Get last day of the month = " + parisTime.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + parisTime.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + parisTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + parisTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }

}
