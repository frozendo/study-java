package com.frozendo.java9.tryresources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesBeforeJava9 {

    public static void main(String[] args) throws IOException {
        System.out.println("Create variable inside try to close resources automatic - see before9.txt file");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("before9.txt"))) {
            bw.write("using try with resources");
            bw.write("resources must be created in try declaration");
        }
    }

}
