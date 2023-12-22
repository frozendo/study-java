package com.frozendo.java8.dateapi.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateGetOptions {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        System.out.println("Day of month = " + date.getDayOfMonth());
        System.out.println("Day of week = " + date.getDayOfWeek());
        System.out.println("Day of year = " + date.getDayOfYear());
        System.out.println("Chronology = " + date.getChronology());
        System.out.println("Era = " + date.getEra());
        System.out.println("Month = " + date.getMonth());
        System.out.println("Month Value = " + date.getMonthValue());
        System.out.println("Year = " + date.getYear());
        System.out.println("Get Long EPOCH DAY = " + date.getLong(ChronoField.EPOCH_DAY));
        System.out.println("Get DAY OF WEEK = " + date.get(ChronoField.DAY_OF_WEEK));
    }

}
