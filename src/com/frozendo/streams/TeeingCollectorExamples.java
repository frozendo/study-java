package com.frozendo.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class TeeingCollectorExamples {

    public static void main(String[] args) {
        TeeingCollectorExamples execute = new TeeingCollectorExamples();

        execute.getBankOperationBalance();
        execute.getMonthWithMoreOperation();
    }

    private void getBankOperationBalance() {
        System.out.println("##### Get balance of bank operations #####");

        var list = buildList();
        final Double balance = list.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(bo -> bo.getOperation().equals("credit"), Collectors.summarizingDouble(BankOperation::getValue)),
                        Collectors.filtering(bo -> bo.getOperation().equals("debt"), Collectors.summarizingDouble(BankOperation::getValue)),
                        (sumCredit, sumDebt) -> sumCredit.getSum() - sumDebt.getSum()
                ));

        System.out.println("Balance of this operations: " + balance);

        System.out.println();
    }

    private void getMonthWithMoreOperation() {
        System.out.println("##### Get the month with more operations #####");

        final String monthWithMoreOperation = buildList().stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(value -> value.getDate().getMonth().equals(Month.APRIL), Collectors.counting()),
                        Collectors.filtering(value -> value.getDate().getMonth().equals(Month.MAY), Collectors.counting()),
                        (aprilCount, mayCount) -> aprilCount > mayCount ? "More operations in April" : "More operations in May"
                ));
        System.out.println(monthWithMoreOperation);

        System.out.println();
    }

    private List<BankOperation> buildList() {
        return List.of(
                new BankOperation("credit", 1000D, LocalDate.of(2022, 4, 12)),
                new BankOperation("debt", 800D, LocalDate.of(2022, 4, 16)),
                new BankOperation("debt", 3000D, LocalDate.of(2022, 4, 23)),
                new BankOperation("credit", 4000D, LocalDate.of(2022, 4, 30)),
                new BankOperation("credit", 2800D, LocalDate.of(2022, 5, 15)),
                new BankOperation("debt", 1300D, LocalDate.of(2022, 5, 25))
        );
    }

    private static class BankOperation {
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
    }

}
