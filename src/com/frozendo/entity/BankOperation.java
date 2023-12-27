package com.frozendo.entity;

import java.time.LocalDate;
import java.util.List;

public class BankOperation {
    private final String operation;
    private final Double value;
    private final LocalDate date;

    public BankOperation(String operation, Double value, LocalDate date) {
        this.operation = operation;
        this.value = value;
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public static List<BankOperation> buildList() {
        return List.of(
                new BankOperation("credit", 1000D, LocalDate.of(2022, 4, 12)),
                new BankOperation("debt", 800D, LocalDate.of(2022, 4, 16)),
                new BankOperation("debt", 3000D, LocalDate.of(2022, 4, 23)),
                new BankOperation("credit", 4000D, LocalDate.of(2022, 4, 30)),
                new BankOperation("credit", 2800D, LocalDate.of(2022, 5, 15)),
                new BankOperation("debt", 1300D, LocalDate.of(2022, 5, 25))
        );
    }
}
