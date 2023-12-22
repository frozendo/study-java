package com.frozendo.java8.dateapi.zoneddatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeGetOperations {

    public static void main(String[] args) {
        ZoneId parisId = ZoneId.of("Europe/Paris");
        ZonedDateTime parisTime = ZonedDateTime.now(parisId);

        System.out.println("Day of month = " + parisTime.getDayOfMonth());
        System.out.println("Day of week = " + parisTime.getDayOfWeek());
        System.out.println("Day of year = " + parisTime.getDayOfYear());
    }

}
