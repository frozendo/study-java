package com.frozendo.java9.processapi;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExecuteActionOnExitWithProcessHandle {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        System.out.println("Start Calculator");
        long processId = new ProcessBuilder("gnome-calculator").start().pid();

        Optional<ProcessHandle> optProcessHandle = ProcessHandle.of(processId);

        if (optProcessHandle.isPresent()) {
            ProcessHandle processHandle = optProcessHandle.get();

            Thread.sleep(2000);

            processHandle.destroy();

            CompletableFuture<ProcessHandle> onProcessExit = processHandle.onExit();
            onProcessExit.get();
            onProcessExit.thenAccept(consumer ->
                    System.out.println("Process id " + consumer.pid() + " was destroyed"));
        }

    }

}
