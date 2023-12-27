package com.frozendo.java9.stackwalkapi;

import java.util.Arrays;

public class StackTraceOldWay {

    public static void main(String[] args) {
        StackTraceOldWay execute = new StackTraceOldWay();
        execute.startChainForExample();
    }

    private void startChainForExample() {
        double sqrt = Math.sqrt(256D);
        System.out.println("SQRT = " + sqrt);
        secondMethodOnChain();
    }

    private void secondMethodOnChain() {
        int sumResult = 2 + 2;
        System.out.println("Sum = " + sumResult);
        stackTraceOldWay();
    }

    private void stackTraceOldWay() {
        System.out.println("Get stack trace from current thread");
        StackTraceElement[] currentThreadTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(Arrays.toString(currentThreadTraceElements));

        System.out.println();

        System.out.println("Get stack trace from exception");
        StackTraceElement[] exceptionTraceElements = new Exception().getStackTrace();
        System.out.println(Arrays.toString(exceptionTraceElements));
    }

}
