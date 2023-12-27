package com.frozendo.java9.processapi;

import java.util.Optional;

public class ProcessHandleParent {

    public static void main(String[] args) {
        ProcessHandle processHandle = ProcessHandle.current();
        Optional<ProcessHandle> parent = processHandle.parent();

        System.out.println("Current process id: " + processHandle.pid());
        parent.ifPresent(handle -> System.out.println("Current process parent id: " + handle.pid()));
    }

}
