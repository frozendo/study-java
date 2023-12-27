package com.frozendo.java9.streams.streamofnullable;

import java.util.stream.Stream;

public class StreamOfWithNullElement {

    public static void main(String[] args) {
        try {
            Stream.of(null)
                    .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error when use 'of' with null value");
            ex.printStackTrace();
        }
    }

}
