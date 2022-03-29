package com.frozendo.apis;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class ProcessApiExamples {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        ProcessApiExamples execute = new ProcessApiExamples();

        execute.getProcessId();
        execute.startProcess();
        execute.startProcessAndGetProcessHandle();
        execute.processHandleParent();
        execute.checkIfProcessIsAlive();
        execute.executeActionOnExitWithProcess();
        execute.executeActionOnExitWithProcessHandle();
        execute.getAllProcessInfo();
        execute.getProcessChildren();
        execute.getProcessDescendants();
    }

    private void getProcessId() {
        System.out.println("##### Get Process ID #####");

        String pName = ManagementFactory.getRuntimeMXBean().getName();
        int oldpid = Integer.parseInt(pName.split("@")[0]);
        System.out.println("Old way = " + oldpid);

        Long newpid = ProcessHandle.current().pid();
        System.out.println("New way = " + newpid);
        System.out.println();
    }

    private void startProcess() throws IOException, InterruptedException {
        System.out.println("##### Start and destroy a process #####");

        System.out.println("Start calculator");
        ProcessBuilder builder = new ProcessBuilder("gnome-calculator");
        Process process = builder.start();

        Thread.sleep(2000);

        System.out.println("Destroy calculator");
        process.destroy();

        System.out.println();
    }

    private void startProcessAndGetProcessHandle() throws IOException, InterruptedException {
        System.out.println("##### Start a process and get processHandle #####");

        System.out.println("Start Calculator and get his processHandle");
        ProcessHandle processHandle = new ProcessBuilder("gnome-calculator")
                .start()
                .toHandle();

        System.out.println("Process Handle id: " + processHandle.pid());
        System.out.println("Check if process isAlive with ProcessHandle: " + processHandle.isAlive());

        Thread.sleep(2000);

        System.out.println("Destroy calculator");
        processHandle.destroy();

        System.out.println();
    }

    private void processHandleParent() {
        System.out.println("##### Get parent of current process #####");

        ProcessHandle processHandle = ProcessHandle.current();
        Optional<ProcessHandle> parent = processHandle.parent();

        parent.ifPresent(handle -> System.out.println("Parent current process id: " + handle.pid()));

        System.out.println();

    }

    private void checkIfProcessIsAlive() throws IOException, InterruptedException {
        System.out.println("##### Start and check a process #####");

        System.out.println("Start Text Editor");
        ProcessBuilder builder = new ProcessBuilder("gedit");
        Process process = builder.start();

        Thread.sleep(2000);

        if (process.isAlive()) {
            System.out.println("Process is alive");
        }

        System.out.println("Destroy Text Editor");
        process.destroy();

        Thread.sleep(2000);

        if (!process.isAlive()) {
            System.out.println("Process is not alive");
        }

        System.out.println();
    }

    private void executeActionOnExitWithProcess() throws IOException, InterruptedException, ExecutionException {
        System.out.println("##### Execute acton with onExit - Process #####");

        System.out.println("Start Text Editor");
        ProcessBuilder builder = new ProcessBuilder("gedit");
        Process process = builder.start();

        Thread.sleep(2000);

        process.destroy();

        CompletableFuture<Process> onProcessExit =  process.onExit();
        onProcessExit.get();
        onProcessExit.thenAccept(consumer -> {
            System.out.println("Process id " + consumer.pid() + " was destroyed");
        });

        System.out.println();
    }

    private void executeActionOnExitWithProcessHandle() throws IOException, InterruptedException, ExecutionException {
        System.out.println("##### Execute acton with onExit - Process #####");

        System.out.println("Start Calculator");
        long processId = new ProcessBuilder("gnome-calculator").start().pid();

        Optional<ProcessHandle> optProcessHandle = ProcessHandle.of(5964);

        if (optProcessHandle.isPresent()) {
            ProcessHandle processHandle = optProcessHandle.get();

            Thread.sleep(2000);

            processHandle.destroy();

            CompletableFuture<ProcessHandle> onProcessExit = processHandle.onExit();
            onProcessExit.get();
            onProcessExit.thenAccept(consumer -> {
                System.out.println("Process id " + consumer.pid() + " was destroyed");
            });
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
                .filter(i -> i.children().findAny().isPresent())
                .findFirst();

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

        System.out.println();
    }

    private void getProcessDescendants() {
        System.out.println("##### Get process descendants #####");
        Optional<ProcessHandle> process = ProcessHandle.allProcesses()
                .filter(i -> i.children().findAny().isPresent())
                .findFirst();

        ProcessHandle.Info info = process.get().info();
        System.out.print("PID: " + process.get().pid());
        System.out.print(", Instance: " + info.startInstant());
        System.out.print(", Total CPU: " + info.totalCpuDuration());
        System.out.print(", User: " + info.user());
        System.out.print(", Command: " + info.command());
        System.out.print(", Args: " + info.arguments());
        System.out.println();

        Stream<ProcessHandle> descendants = process.get().descendants();

        descendants.limit(5)
                .forEach(ph -> {
                    ProcessHandle.Info cInfo = ph.info();
                    System.out.print("Descendants PID: " + ph.pid());
                    System.out.print(", Descendants Instance: " + cInfo.startInstant());
                    System.out.print(", Descendants User: " + cInfo.user());
                    System.out.print(", Descendants Total CPU: " + cInfo.totalCpuDuration());
                    System.out.print(", Descendants Command: " + cInfo.command());
                    System.out.print(", Descendants Args: " + cInfo.arguments());
                    System.out.println();
                });

        System.out.println();
    }

}
