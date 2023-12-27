package com.frozendo.java9.tryresources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NewTryWithResourcesFinalVariable {

    public static void main(String[] args) throws IOException {
        final FileWriter fw = new FileWriter("java9finalVariable.txt");
        final BufferedWriter bw = new BufferedWriter(fw);

        try (fw;bw) {
            bw.write("using final variable in try with resource");
        }
    }

}
