package com.frozendo.java9.processapi;

import java.io.IOException;

public class StartNewProcess {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Start calculator");
        ProcessBuilder builder = new ProcessBuilder("gnome-calculator");
        Process process = builder.start();

        Thread.sleep(2000);

        System.out.println("Destroy calculator");
        process.destroy();

        System.out.println();
    }

}
