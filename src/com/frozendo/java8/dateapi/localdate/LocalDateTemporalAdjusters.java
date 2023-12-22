package com.frozendo.java8.dateapi.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTemporalAdjusters {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        System.out.println("Get last day of the month = " + date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + date.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }

}
