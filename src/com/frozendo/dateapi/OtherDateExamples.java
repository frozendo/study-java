package com.frozendo.dateapi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class OtherDateExamples {

    public static void main(String[] args) throws InterruptedException {
        OtherDateExamples execute = new OtherDateExamples();

        execute.instantFunctions();
        execute.periodFunctions();
        execute.durationFunctions();
    }

    private void instantFunctions() throws InterruptedException {
        System.out.println("##### Instant #####");
        //get instant now
        Instant now = Instant.now();
        System.out.println("Instant now = " + now);

        //get instant form a point in time
        //the parameter determines how many seconds since 01/01/1970
        Instant epochSecond = Instant.ofEpochSecond(200000000);
        System.out.println("Instant in time = " + epochSecond);

        //Calculate duration of an event
        Instant init = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();

        System.out.println("Duration of the event = " + Duration.between(init, end));
        System.out.println();
    }

    private void periodFunctions() {
        System.out.println("##### Period #####");

        Period period = Period.of(2, 5, 20);
        System.out.println("Two years, five months and twenty days = " + period);
        System.out.println("Thirty five days = " + Period.ofDays(35));
        System.out.println("Twenty two months = " + Period.ofMonths(22));
        System.out.println("Five years = " + Period.ofYears(5));

        LocalDate localDate = LocalDate.now();
        LocalDate minusDate = localDate.minus(period);

        System.out.println("Remove a period from date now = " + minusDate);
        System.out.println("Add a period from date now = " + localDate.plus(period));

        System.out.println("Calculate the difference between two dates = " + Period.between(minusDate, localDate));
        System.out.println();
    }

    private void durationFunctions() {
        System.out.println("##### Duration #####");

        System.out.println("Duration of days = " + Duration.ofDays(10));
        System.out.println("Duration of hours = " + Duration.ofHours(2));
        System.out.println("Duration of minutes = " + Duration.ofMinutes(20));
        System.out.println("Duration of seconds = " + Duration.ofSeconds(40));

        Duration oneHour = Duration.between(LocalTime.now().minusHours(1), LocalTime.now());
        System.out.println("Duration between two times = " + oneHour);
    }

}

