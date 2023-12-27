package com.frozendo.java9.processapi;

import java.util.stream.Stream;

public class ProcessHandleGetProcessInfo {

    public static void main(String[] args) {
        Stream<ProcessHandle> liveProcesses = ProcessHandle.allProcesses();
        liveProcesses
                .filter(ProcessHandle::isAlive)
                .filter(i -> i.info().command().isPresent())
                .limit(5)
                .forEach(ph -> {
                    ProcessHandle.Info info = ph.info();
                    System.out.print("PID: " + ph.pid());
                    System.out.print(", Instance: " + info.startInstant());
                    System.out.print(", User: " + info.user());
                    System.out.print(", Command: " + info.command());
                    System.out.print(", Args: " + info.arguments());
                    System.out.println();
                });
    }

}
