package com.frozendo.java8.dateapi.offsetdatetime;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeGetOptions {

    public static void main(String[] args) {
        ZoneOffset parisOffset = ZoneOffset.of("+01:00");
        OffsetDateTime parisTime = OffsetDateTime.now(parisOffset);

        System.out.println("Day of month = " + parisTime.getDayOfMonth());
        System.out.println("Day of week = " + parisTime.getDayOfWeek());
        System.out.println("Day of year = " + parisTime.getDayOfYear());
    }

}
