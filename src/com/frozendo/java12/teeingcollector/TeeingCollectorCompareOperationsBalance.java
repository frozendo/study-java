package com.frozendo.java12.teeingcollector;

import com.frozendo.entity.BankOperation;

import java.util.stream.Collectors;

public class TeeingCollectorCompareOperationsBalance {

    public static void main(String[] args) {
        var list = BankOperation.buildList();
        final Double balance = list.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(bo -> bo.getOperation().equals("credit"), Collectors.summarizingDouble(BankOperation::getValue)),
                        Collectors.filtering(bo -> bo.getOperation().equals("debt"), Collectors.summarizingDouble(BankOperation::getValue)),
                        (sumCredit, sumDebt) -> sumCredit.getSum() - sumDebt.getSum()
                ));

        System.out.println("Balance of this operations: " + balance);
    }

}
