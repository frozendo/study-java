package com.frozendo.java9.processapi;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExecuteActionOnExitWithProcess {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        System.out.println("Start Text Editor");
        ProcessBuilder builder = new ProcessBuilder("gedit");
        Process process = builder.start();

        Thread.sleep(2000);

        process.destroy();

        CompletableFuture<Process> onProcessExit =  process.onExit();
        onProcessExit.get();
        onProcessExit.thenAccept(consumer ->
                System.out.println("Process id " + consumer.pid() + " was destroyed"));

        System.out.println();
    }

}
