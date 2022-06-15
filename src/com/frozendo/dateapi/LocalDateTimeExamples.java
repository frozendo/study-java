package com.frozendo.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeExamples {

    public static void main(String[] args) {
        LocalDateTimeExamples execute = new LocalDateTimeExamples();
        LocalDateTime dateTime = LocalDateTime.now();

        execute.createLocalDateTime();
        execute.localDatetimeGetOptions(dateTime);
        execute.setDateTimeNewValue(dateTime);
        execute.plusDatetime(dateTime);
        execute.minusDatetime(dateTime);
        execute.temporalAdjusters(dateTime);
    }

    private void createLocalDateTime() {
        System.out.println("##### Create methods #####");
        System.out.println("LocalDateTime now = " + LocalDateTime.now());
        System.out.println("LocalDateTime of = " + LocalDateTime.of(2021, 1, 29, 17, 33));
        System.out.println("LocalDateTime parse = " + LocalDateTime.parse("2021-03-19T11:44"));
        System.out.println();
    }

    private void plusDatetime(LocalDateTime dateTime) {
        System.out.println("##### Plus date values #####");
        System.out.println("Plus 2 weeks and 1 year = " + dateTime.plusWeeks(2).plusYears(1));
        System.out.println("Plus 9 hours and 100 seconds = " + dateTime.plusHours(9).plusSeconds(100));
        System.out.println("Plus 10 months and 20 minutes = " + dateTime.plusMonths(10).plusMinutes(20));
        System.out.println();
    }

    private void localDatetimeGetOptions(LocalDateTime dateTime) {
        System.out.println("##### LocalDateTime get examples #####");
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
        System.out.println();
    }

    private void setDateTimeNewValue(LocalDateTime dateTime) {
        System.out.println("##### Defining new date value #####");
        System.out.println("Set date to hundredth day of the year = " + dateTime.withDayOfYear(100));
        System.out.println("Set time to 15:29 = " + dateTime.withHour(15).withMinute(59));
        System.out.println("Set date to 25/12/1990 = " + dateTime.withDayOfMonth(25).withMonth(12).withYear(1990));
        System.out.println();
    }

    private void minusDatetime(LocalDateTime dateTime) {
        System.out.println("##### Minus date values #####");
        System.out.println("Minus 2 weeks and 1 year = " + dateTime.minusWeeks(2).minusYears(1));
        System.out.println("Minus 9 hours and 100 seconds = " + dateTime.minusHours(9).minusSeconds(100));
        System.out.println("Minus 10 months and 20 minutes = " + dateTime.minusMonths(10).minusMinutes(20));
        System.out.println();
    }

    private void temporalAdjusters(LocalDateTime dateTime) {
        System.out.println("##### Temporal Adjusters examples #####");
        System.out.println("Get last day of the month = " + dateTime.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + dateTime.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + dateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + dateTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }
}
