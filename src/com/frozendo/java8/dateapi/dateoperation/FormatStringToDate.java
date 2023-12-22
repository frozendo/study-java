package com.frozendo.java8.dateapi.dateoperation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatStringToDate {
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static void main(String[] args) {
        System.out.println(LocalDate.parse("2020-W10-3", DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println(LocalDate.parse("24/07/2020", DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println(LocalDateTime.parse("2019-08-24T21:23:27.157597", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.parse("24/01/2021 21:23:27", DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
    }

}
