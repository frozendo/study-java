package com.frozendo.dateapi;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeExamples {

    public static void main(String[] args) {
        LocalTimeExamples execute = new LocalTimeExamples();
        LocalTime time = LocalTime.now();

        execute.createLocalTime();
        execute.timeGetOptions(time);
        execute.setTimeNewValue(time);
        execute.plusValue(time);
        execute.minusValue(time);
    }

    private void createLocalTime() {
        System.out.println("##### Create methods #####");
        System.out.println("LocalTime now = " + LocalTime.now());
        System.out.println("LocalTime of = " + LocalTime.of(19, 20));
        System.out.println("LocalTime parse = " + LocalTime.parse("20:30"));
        System.out.println();
    }

    private void timeGetOptions(LocalTime time) {
        System.out.println("##### LocalTime get examples #####");
        System.out.println("Hour = " + time.getHour());
        System.out.println("Minute = " + time.getMinute());
        System.out.println("Second = " + time.getSecond());
        System.out.println("Nano = " + time.getNano());
        System.out.println("Get Long AM PM OF DAY = " + time.getLong(ChronoField.AMPM_OF_DAY));
        System.out.println("Get CLOCK HOUR OF DAY = " + time.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println();
    }

    private void setTimeNewValue(LocalTime time) {
        System.out.println("##### Defining new time value #####");
        System.out.println("Set hour to 15 and minute to 59 = " + time.withHour(15).withMinute(59));
        System.out.println("Set second to 58 = " + time.withSecond(58));
        System.out.println("Set nano to 33 = " + time.withNano(33));
        System.out.println();
    }

    private void plusValue(LocalTime time) {
        System.out.println("##### Plus time values #####");
        System.out.println("Plus 9 hours and 100 seconds = " + time.plusHours(9).plusSeconds(100));
        System.out.println("Plus 115 minutes = " + time.plusMinutes(115));
        System.out.println("Plus 60 nanos = " + time.plusNanos(60));
        System.out.println();
    }

    private void minusValue(LocalTime time) {
        System.out.println("##### Minus time values #####");
        System.out.println("Minus 9 hours and 100 seconds = " + time.minusHours(9).minusSeconds(100));
        System.out.println("Minus 115 minutes = " + time.minusMinutes(115));
        System.out.println("Minus 60 nanos = " + time.minusNanos(60));
        System.out.println();
    }
}
