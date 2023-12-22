package com.frozendo.java8.dateapi.localtime;

import java.time.LocalTime;

public class LocalTimeSetNewValues {

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println("Set hour to 15 and minute to 59 = " + time.withHour(15).withMinute(59));
        System.out.println("Set second to 58 = " + time.withSecond(58));
        System.out.println("Set nano to 33 = " + time.withNano(33));
    }

}
