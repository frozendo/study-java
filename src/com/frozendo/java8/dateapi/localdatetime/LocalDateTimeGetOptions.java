package com.frozendo.java8.dateapi.localdatetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class LocalDateTimeGetOptions {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Day of Month = " + dateTime.getDayOfMonth());
        System.out.println("Day of Week = " + dateTime.getDayOfWeek());
        System.out.println("Day of Year = " + dateTime.getDayOfYear());
        System.out.println("Chronology = " + dateTime.getChronology());
        System.out.println("Month = " + dateTime.getMonth());
        System.out.println("Month Value = " + dateTime.getMonthValue());
        System.out.println("Year = " + dateTime.getYear());
        System.out.println("Hour = " + dateTime.getHour());
        System.out.println("Minute = " + dateTime.getMinute());
        System.out.println("Second = " + dateTime.getSecond());
        System.out.println("Nano = " + dateTime.getNano());
        System.out.println("Get Long EPOCH DAY = " + dateTime.getLong(ChronoField.EPOCH_DAY));
        System.out.println("Get DAY OF WEEK = " + dateTime.get(ChronoField.DAY_OF_WEEK));
        System.out.println("Get Long AM PM OF DAY = " + dateTime.getLong(ChronoField.AMPM_OF_DAY));
        System.out.println("Get CLOCK HOUR OF DAY = " + dateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
    }

}
