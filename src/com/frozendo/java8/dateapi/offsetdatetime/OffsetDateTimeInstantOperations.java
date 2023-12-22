package com.frozendo.java8.dateapi.offsetdatetime;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeInstantOperations {

    public static void main(String[] args) {
        ZoneOffset zoneOffset = ZoneOffset.of("-05:00");
        OffsetDateTime chigagoTime = OffsetDateTime.now(zoneOffset);
        System.out.println("Datetime now in Chicago = " + chigagoTime);
        System.out.println("Same instant offset = " + chigagoTime.withOffsetSameInstant(ZoneOffset.of("+11:00")));
        System.out.println("Same local offset = " + chigagoTime.withOffsetSameLocal(ZoneOffset.of("+11:00")));
    }

}
