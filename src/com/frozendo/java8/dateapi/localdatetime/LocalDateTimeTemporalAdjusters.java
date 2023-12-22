package com.frozendo.java8.dateapi.localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTemporalAdjusters {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Temporal Adjusters examples");
        System.out.println("Get last day of the month = " + dateTime.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + dateTime.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + dateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + dateTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }

}
