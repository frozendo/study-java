package com.frozendo.features;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesExamples {

    public static void main(String[] args) {
        TryWithResourcesExamples execute = new TryWithResourcesExamples();
        try {
            execute.beforeJava7();
            execute.beforeJava9();
            execute.afterJava9WithFinalVariables();
            execute.afterJava9WithEffectivelyFinalVariables();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void beforeJava7() throws IOException {
        System.out.println("##### Closes resources by hand - see before7.txt file #####");
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("before7.txt");
            bw = new BufferedWriter(fw);
            bw.write("close resources by hand");
        } finally {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        }
    }

    private void beforeJava9() throws IOException {
        System.out.println("##### Create variable inside try to close resources automatic - see before9.txt file #####");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("before9.txt"))) {
            bw.write("using try with resources");
            bw.write("resources must be created in try declaration");
        }
    }

    private void afterJava9WithFinalVariables() throws IOException {
        System.out.println("##### Using final variable in a try - see java9finalVariable.txt file #####");
        final FileWriter fw = new FileWriter("java9finalVariable.txt");
        final BufferedWriter bw = new BufferedWriter(fw);

        try (fw;bw) {
            bw.write("using final variable in try with resource");
        }
    }

    private void afterJava9WithEffectivelyFinalVariables() throws IOException {
        System.out.println("##### Using effectively final variable in a try - see java9effectivelyFinalVariable.txt file #####");
        FileWriter fw = new FileWriter("java9effectivelyFinalVariable.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        try (fw;bw) {
            bw.write("using effectively final variable in try with resource");
        }
    }

}
