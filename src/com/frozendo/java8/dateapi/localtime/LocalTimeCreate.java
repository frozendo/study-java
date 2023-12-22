package com.frozendo.java8.dateapi.localtime;

import java.time.LocalTime;

public class LocalTimeCreate {

    public static void main(String[] args) {
        System.out.println("LocalTime now = " + LocalTime.now());
        System.out.println("LocalTime of = " + LocalTime.of(19, 20));
        System.out.println("LocalTime parse = " + LocalTime.parse("20:30"));
    }

}
