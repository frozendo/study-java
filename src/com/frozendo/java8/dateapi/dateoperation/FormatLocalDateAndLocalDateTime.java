package com.frozendo.java8.dateapi.dateoperation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatLocalDateAndLocalDateTime {

    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Format date to ISO WEEK DATE = " + date.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println("Format date to specific date pattern = " + date.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));

        System.out.println();

        System.out.println("Format date to ISO LOCAL DATE TIME = " + dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("Format date to specific date time pattern = " + dateTime.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
    }

}
