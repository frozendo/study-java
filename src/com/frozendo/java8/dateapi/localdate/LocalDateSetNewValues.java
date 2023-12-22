package com.frozendo.java8.dateapi.localdate;

import java.time.LocalDate;

public class LocalDateSetNewValues {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        System.out.println("Defining new date value");
        System.out.println("Set date to hundredth day of the year = " + date.withDayOfYear(100));
        System.out.println("Set date to month number 10 (October) = " + date.withMonth(10));
        System.out.println("Set date to twentieth day of the month " + date.withDayOfMonth(20));
    }

}
