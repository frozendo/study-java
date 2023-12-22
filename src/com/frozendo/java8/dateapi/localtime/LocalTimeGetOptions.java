package com.frozendo.java8.dateapi.localtime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeGetOptions {

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println("Hour = " + time.getHour());
        System.out.println("Minute = " + time.getMinute());
        System.out.println("Second = " + time.getSecond());
        System.out.println("Nano = " + time.getNano());
        System.out.println("Get Long AM PM OF DAY = " + time.getLong(ChronoField.AMPM_OF_DAY));
        System.out.println("Get CLOCK HOUR OF DAY = " + time.get(ChronoField.CLOCK_HOUR_OF_DAY));
    }

}
