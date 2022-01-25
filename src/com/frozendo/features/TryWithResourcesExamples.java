package com.frozendo.features;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResourcesExamples {

    public static void main(String[] args) {
        TryWithResourcesExamples examples = new TryWithResourcesExamples();
        try {
            examples.beforeJava7();
            examples.beforeJava9();
            examples.afterJava9WithFinalVariables();
            examples.afterJava9WithEffectivelyFinalVariables();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void beforeJava7() throws IOException {
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

    public void beforeJava9() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("before9.txt"))) {
            bw.write("using try with resources");
            bw.write("resources must be created in try declaration");
        }
    }

    public void afterJava9WithFinalVariables() throws IOException {
        final FileWriter fw = new FileWriter("java9finalvariable.txt");
        final BufferedWriter bw = new BufferedWriter(fw);

        try (fw;bw) {
            bw.write("using final variable in try with resource");
        }
    }

    public void afterJava9WithEffectivelyFinalVariables() throws IOException {
        FileWriter fw = new FileWriter("java9effectivelyfinalvariable.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        try (fw;bw) {
            bw.write("using effectively final variable in try with resource");
        }
    }

}
