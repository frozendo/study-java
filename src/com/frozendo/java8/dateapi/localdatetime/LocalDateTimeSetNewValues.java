package com.frozendo.java8.dateapi.localdatetime;

import java.time.LocalDateTime;

public class LocalDateTimeSetNewValues {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Set date to hundredth day of the year = " + dateTime.withDayOfYear(100));
        System.out.println("Set time to 15:29 = " + dateTime.withHour(15).withMinute(59));
        System.out.println("Set date to 25/12/1990 at 11:28 = " + dateTime.withDayOfMonth(25).withMonth(12)
                .withYear(1990).withHour(11).withMinute(28));
    }

}
