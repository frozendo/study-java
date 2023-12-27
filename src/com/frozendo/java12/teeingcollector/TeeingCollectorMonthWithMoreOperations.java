package com.frozendo.java12.teeingcollector;

import com.frozendo.entity.BankOperation;

import java.time.Month;
import java.util.stream.Collectors;

public class TeeingCollectorMonthWithMoreOperations {

    public static void main(String[] args) {
        final String monthWithMoreOperation = BankOperation.buildList()
                .stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(value -> value.getDate().getMonth().equals(Month.APRIL), Collectors.counting()),
                        Collectors.filtering(value -> value.getDate().getMonth().equals(Month.MAY), Collectors.counting()),
                        (aprilCount, mayCount) -> aprilCount > mayCount ? "More operations in April" : "More operations in May"
                ));
        System.out.println(monthWithMoreOperation);
    }

}
