package com.frozendo.java8.dateapi.dateoperation;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatZonedDateTimeAndOffsetDateTime {
    private static final String DATE_PATTERN = "dd/MM/yyyy";
    private static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        System.out.println("Format zonedDateTime to ISO WEEK DATE = " + zonedDateTime.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println("Format zonedDateTime to a specific date pattern = " + zonedDateTime.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("Format zonedDateTime to ISO LOCAL DATE TIME = " + zonedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("Format zonedDateTime to a specific date time pattern = " + zonedDateTime.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));

        System.out.println();

        System.out.println("Format offsetDateTime to ISO WEEK DATE = " + offsetDateTime.format(DateTimeFormatter.ISO_WEEK_DATE));
        System.out.println("Format offsetDateTime to a specific date pattern = " + offsetDateTime.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
        System.out.println("Format offsetDateTime to ISO LOCAL DATE TIME = " + offsetDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("Format offsetDateTime to a specific date time pattern = " + offsetDateTime.format(DateTimeFormatter.ofPattern(DATETIME_PATTERN)));
    }

}
