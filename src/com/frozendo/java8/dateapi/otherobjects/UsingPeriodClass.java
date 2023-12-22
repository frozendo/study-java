package com.frozendo.java8.dateapi.otherobjects;

import java.time.LocalDate;
import java.time.Period;

public class UsingPeriodClass {

    public static void main(String[] args) {
        Period period = Period.of(2, 5, 20);
        System.out.println("Two years, five months and twenty days = " + period);
        System.out.println("Thirty five days = " + Period.ofDays(35));
        System.out.println("Twenty two months = " + Period.ofMonths(22));
        System.out.println("Five years = " + Period.ofYears(5));

        System.out.println();

        LocalDate localDate = LocalDate.now();
        LocalDate minusDate = localDate.minus(period);

        System.out.println("Remove a period from date now = " + minusDate);
        System.out.println("Add a period from date now = " + localDate.plus(period));

        System.out.println();

        System.out.println("Calculate the difference between two dates = " + Period.between(minusDate, localDate));
    }

}
