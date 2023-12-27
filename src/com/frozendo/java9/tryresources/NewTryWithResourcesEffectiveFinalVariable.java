package com.frozendo.java9.tryresources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NewTryWithResourcesEffectiveFinalVariable {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("java9effectivelyFinalVariable.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        try (fw;bw) {
            bw.write("using effectively final variable in try with resource");
        }
    }

}
