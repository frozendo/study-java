package com.frozendo.java8.dateapi.localtime;

import java.time.LocalTime;

public class LocalTimePlusAndMinusValues {

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println("Plus 9 hours and 100 seconds = " + time.plusHours(9).plusSeconds(100));
        System.out.println("Plus 115 minutes = " + time.plusMinutes(115));
        System.out.println("Plus 60 nanos = " + time.plusNanos(60));

        System.out.println();

        System.out.println("Minus 9 hours and 100 seconds = " + time.minusHours(9).minusSeconds(100));
        System.out.println("Minus 115 minutes = " + time.minusMinutes(115));
        System.out.println("Minus 60 nanos = " + time.minusNanos(60));
    }
}
