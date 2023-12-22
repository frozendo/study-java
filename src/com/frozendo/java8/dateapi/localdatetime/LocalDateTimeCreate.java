package com.frozendo.java8.dateapi.localdatetime;

import java.time.LocalDateTime;

public class LocalDateTimeCreate {

    public static void main(String[] args) {
        System.out.println("LocalDateTime now = " + LocalDateTime.now());
        System.out.println("LocalDateTime of = " + LocalDateTime.of(2021, 1, 29, 17, 33));
        System.out.println("LocalDateTime parse = " + LocalDateTime.parse("2021-03-19T11:44"));
    }

}
