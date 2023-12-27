package com.frozendo.java9.processapi;

import java.util.Optional;
import java.util.stream.Stream;

public class ProcessHandleGetProcessChildren {

    public static void main(String[] args) {
        Optional<ProcessHandle> process = ProcessHandle.allProcesses()
                .filter(i -> i.children().findAny().isPresent())
                .findFirst();

        if (process.isPresent()) {

            ProcessHandle.Info info = process.get().info();
            System.out.print("PID: " + process.get().pid());
            System.out.print(", Instance: " + info.startInstant());
            System.out.print(", Total CPU: " + info.totalCpuDuration());
            System.out.print(", User: " + info.user());
            System.out.print(", Command: " + info.command());
            System.out.print(", Args: " + info.arguments());
            System.out.println();

            Stream<ProcessHandle> children = process.get().children();

            children.limit(5)
                    .forEach(ph -> {
                        ProcessHandle.Info cInfo = ph.info();
                        System.out.print("Children PID: " + ph.pid());
                        System.out.print(", Children Instance: " + cInfo.startInstant());
                        System.out.print(", Children Total CPU: " + cInfo.totalCpuDuration());
                        System.out.print(", Children User: " + cInfo.user());
                        System.out.print(", Children Command: " + cInfo.command());
                        System.out.print(", Children Args: " + cInfo.arguments());
                        System.out.println();
                    });
        }
    }

}
