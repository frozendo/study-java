package com.frozendo.improvedapi;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Optional;
import java.util.stream.Stream;

public class ProcessApiExamples {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessApiExamples execute = new ProcessApiExamples();

        execute.getProcessId();
        execute.startSublimeProcess();
        execute.checkIfProcessIsAlive();
        execute.getAllProcessInfo();
        execute.getProcessChildren();
        execute.getProcessDescendants();
    }

    private void getProcessId() {
        System.out.println("##### Get Process ID #####");

        String pName = ManagementFactory.getRuntimeMXBean().getName();
        Integer oldpid = Integer.parseInt(pName.split("@")[0]);
        System.out.println("Old way = " + oldpid);

        Long newpid = ProcessHandle.current().pid();
        System.out.println("New way = " + newpid);
        System.out.println();
    }

    private void startSublimeProcess() throws IOException, InterruptedException {
        System.out.println("##### Start and destroy a process #####");

        System.out.println("Start calculator");
        ProcessBuilder builder = new ProcessBuilder("gnome-calculator");
        Process process = builder.start();

        Thread.sleep(2000);

        System.out.println("Destroy calculator");
        process.destroy();

        System.out.println();
    }

    private void checkIfProcessIsAlive() throws IOException, InterruptedException {
        System.out.println("##### Start and check a process #####");

        System.out.println("Start calculator");
        ProcessBuilder builder = new ProcessBuilder("gnome-calculator");
        Process process = builder.start();

        Thread.sleep(2000);

        if (process.isAlive()) {
            System.out.println("Process is alive");
        }

        System.out.println("Destroy calculator");
        process.destroy();

        Thread.sleep(2000);

        if (!process.isAlive()) {
            System.out.println("Process is not alive");
        }

        System.out.println();
    }

    private void getAllProcessInfo() {
        System.out.println("##### Get all processes and its info #####");
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
        System.out.println();
    }

    private void getProcessChildren() {
        System.out.println("##### Get process children #####");
        Optional<ProcessHandle> process = ProcessHandle.allProcesses()
                .filter(i -> i.children().count() > 0)
                .findFirst();

        ProcessHandle.Info info = process.get().info();
        System.out.print("PID: " + process.get().pid());
        System.out.print(", Instance: " + info.startInstant());
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
                    System.out.print(", Children User: " + cInfo.user());
                    System.out.print(", Children Command: " + cInfo.command());
                    System.out.print(", Children Args: " + cInfo.arguments());
                    System.out.println();
                });

        System.out.println();
    }

    private void getProcessDescendants() {
        System.out.println("##### Get process descendants #####");
        Optional<ProcessHandle> process = ProcessHandle.allProcesses()
                .filter(i -> i.children().count() > 0)
                .findFirst();

        ProcessHandle.Info info = process.get().info();
        System.out.print("PID: " + process.get().pid());
        System.out.print(", Instance: " + info.startInstant());
        System.out.print(", User: " + info.user());
        System.out.print(", Command: " + info.command());
        System.out.print(", Args: " + info.arguments());
        System.out.println();

        Stream<ProcessHandle> children = process.get().descendants();

        children.limit(5)
                .forEach(ph -> {
                    ProcessHandle.Info cInfo = ph.info();
                    System.out.print("Descendants PID: " + ph.pid());
                    System.out.print(", Descendants Instance: " + cInfo.startInstant());
                    System.out.print(", Descendants User: " + cInfo.user());
                    System.out.print(", Descendants Command: " + cInfo.command());
                    System.out.print(", Descendants Args: " + cInfo.arguments());
                    System.out.println();
                });

        System.out.println();
    }

}
