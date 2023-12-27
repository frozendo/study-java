package com.frozendo.java9.processapi;

import java.io.IOException;

public class StartNewProcessAndGetProcessHandle {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Start Calculator and get his processHandle");
        ProcessHandle processHandle = new ProcessBuilder("gnome-calculator")
                .start()
                .toHandle();

        System.out.println("Process Handle id: " + processHandle.pid());
        System.out.println("Check if process is alive with ProcessHandle: " + processHandle.isAlive());

        Thread.sleep(2000);

        System.out.println("Destroy calculator");
        processHandle.destroy();

        Thread.sleep(2000);

        System.out.println("Check if process is still alive with ProcessHandle: " + processHandle.isAlive());
    }

}
