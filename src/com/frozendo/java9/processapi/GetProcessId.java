package com.frozendo.java9.processapi;

import java.lang.management.ManagementFactory;

public class GetProcessId {

    public static void main(String[] args) {
        String pName = ManagementFactory.getRuntimeMXBean().getName();
        int oldPid = Integer.parseInt(pName.split("@")[0]);
        System.out.println("Old way to get process ID = " + oldPid);

        long newPid = ProcessHandle.current().pid();
        System.out.println("New way to get process ID = " + newPid);
        System.out.println();
    }

}
