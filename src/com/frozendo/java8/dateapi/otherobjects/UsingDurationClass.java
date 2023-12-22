package com.frozendo.java8.dateapi.otherobjects;

import java.time.Duration;
import java.time.LocalTime;

public class UsingDurationClass {

    public static void main(String[] args) {
        System.out.println("Duration of days = " + Duration.ofDays(10));
        System.out.println("Duration of hours = " + Duration.ofHours(2));
        System.out.println("Duration of minutes = " + Duration.ofMinutes(20));
        System.out.println("Duration of seconds = " + Duration.ofSeconds(40));

        System.out.println();

        LocalTime now = LocalTime.now();

        Duration oneHour = Duration.between(now.minusHours(1), now);
        System.out.println("Duration between two times = " + oneHour);
    }

}
