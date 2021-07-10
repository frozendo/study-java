package com.frozendo.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExamples {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        LocalDateExamples example = new LocalDateExamples();

        example.crateLocalDate();
        example.localDateGetOptions(date);
        example.setDateNewValue(date);
        example.plusDateValue(date);
        example.minusDateValue(date);
        example.temporalAdjusters(date);
    }

    private void crateLocalDate() {
        System.out.println("##### Create methods #####");
        System.out.println("LocalDate now = " + LocalDate.now());
        System.out.println("LocalDate of = " + LocalDate.of(2020, 12, 31));
        System.out.println("LocalDate parse = " + LocalDate.parse("2021-03-12"));
        System.out.println();
    }

    private void localDateGetOptions(LocalDate date) {
        System.out.println("##### LocalDate get examples #####");
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
        System.out.println();
    }

    private void setDateNewValue(LocalDate date) {
        System.out.println("##### Defining new date value #####");
        System.out.println("Set date to hundredth day of the year = " + date.withDayOfYear(100));
        System.out.println("Set date to month number 10 (October) = " + date.withMonth(10));
        System.out.println("Set date to twentieth day of the month " + date.withDayOfMonth(20));
        System.out.println();
    }

    private void plusDateValue(LocalDate date) {
        System.out.println("##### Plus date values #####");
        System.out.println("Plus 2 weeks and 1 year = " + date.plusWeeks(2).plusYears(1));
        System.out.println("Plus 2 months = " + date.plusMonths(2));
        System.out.println("Plus 20 days = " + date.plusDays(20));
        System.out.println();
    }

    private void minusDateValue(LocalDate date) {
        System.out.println("##### Minus date values #####");
        System.out.println("Minus 2 weeks and 1 year = " + date.minusWeeks(2).minusYears(1));
        System.out.println("Minus 2 months = " + date.minusMonths(2));
        System.out.println("Minus 20 days = " + date.minusDays(20));
        System.out.println();
    }

    private void temporalAdjusters(LocalDate date) {
        System.out.println("##### Temporal Adjusters examples #####");
        System.out.println("Get last day of the month = " + date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("Get first day of the year = " + date.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("Get the day of next friday = " + date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("Get the day of previous monday = " + date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
    }

}
