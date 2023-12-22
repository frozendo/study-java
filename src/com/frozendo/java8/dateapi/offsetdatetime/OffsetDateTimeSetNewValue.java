package com.frozendo.java8.dateapi.offsetdatetime;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeSetNewValue {

    public static void main(String[] args) {
        ZoneOffset parisOffset = ZoneOffset.of("+01:00");
        OffsetDateTime parisTime = OffsetDateTime.now(parisOffset);

        System.out.println("Set parisTime to hundredth day of the year = " + parisTime.withDayOfYear(100));
        System.out.println("Set parisTime to month number 10 (October) = " + parisTime.withMonth(10));
        System.out.println("Set parisTime to twentieth day of the month " + parisTime.withDayOfMonth(20));
    }

}
