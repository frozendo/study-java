package com.frozendo.java8.dateapi.zoneddatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeSetNewValues {

    public static void main(String[] args) {
        ZoneId parisId = ZoneId.of("Europe/Paris");
        ZonedDateTime parisTime = ZonedDateTime.now(parisId);

        System.out.println("Set parisTime to hundredth day of the year = " + parisTime.withDayOfYear(100));
        System.out.println("Set parisTime to month number 10 (October) = " + parisTime.withMonth(10));
        System.out.println("Set parisTime to twentieth day of the month " + parisTime.withDayOfMonth(20));
    }

}
