package com.frozendo.java8.dateapi.otherobjects;

import java.time.Duration;
import java.time.Instant;

public class UsingInstantClass {

    public static void main(String[] args) throws InterruptedException {
        Instant now = Instant.now();
        System.out.println("Instant now = " + now);

        //get instant form a point in time
        //the parameter determines how many seconds since 01/01/1970
        Instant epochSecond = Instant.ofEpochSecond(200000000);
        System.out.println("Instant in time = " + epochSecond);

        System.out.println();

        //Calculate duration of an event
        Instant init = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();

        System.out.println("Duration of the event = " + Duration.between(init, end));
    }

}
