package com.frozendo.java8.dateapi.zoneddatetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeInstantOperations {

    public static void main(String[] args) {
        ZoneId chicagoZone = ZoneId.of("America/Chicago");
        ZoneId berlinZone = ZoneId.of("Europe/Berlin");

        ZonedDateTime chicagoTime = ZonedDateTime.now(chicagoZone);

        System.out.println("Datetime now in Chicago = " + chicagoTime);
        System.out.println("Same instant in Berlin = " + chicagoTime.withZoneSameInstant(berlinZone));
        System.out.println("Same time with different offset = " + chicagoTime.withZoneSameLocal(berlinZone));
    }

}
