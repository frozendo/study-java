package com.frozendo.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CompareFormatExamples {

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static void main(String[] args) {
        CompareFormatExamples execute = new CompareFormatExamples();
        execute.dataCompare();
        execute.formatDate();
        execute.formatStringToDate();
    }

    private void dataCompare() {
        System.out.println("##### Compare #####");

        LocalDate now = LocalDate.now();
        LocalDate dateInPast = LocalDate.of(2020, 3, 23);
        LocalDate dateInFuture = now.plusYears(2).plusDays(20);

        System.out.println("Date past isAfter " + now.isAfter(dateInPast));
        System.out.println("Date past isBefore = " + now.isBefore(dateInPast));
        System.out.println("Date past isEqual = " + now.isEqual(dateInPast));

        System.out.println("Date future isAfter = " + now.isAfter(dateInFuture));
        System.out.println("Date future isBefore = " + now.isBefore(dateInFuture));
        System.out.println("Date future isEqual = " + now.isEqual(dateInFuture));

        System.out.println();
    }

    private void formatDate() {
        System.out.println("##### Format a date to string #####");

        System.out.println("Use LocalDate and LocalTime");
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));

        System.out.println();

        System.out.println("Use ZonedDateTime");
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
        System.out.println();
    }

    private void formatStringToDate() {
        System.out.println("##### Format a string to date #####");

        System.out.println(LocalDate.parse("2020-W10-3", DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(LocalDate.parse("24/07/2020", DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println(LocalDateTime.parse("2019-08-24T21:23:27.157597", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.parse("24/01/2021 21:23:27", DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
    }

}
