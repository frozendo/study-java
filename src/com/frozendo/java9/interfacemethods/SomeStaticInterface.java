package com.frozendo.java9.interfacemethods;

public interface SomeStaticInterface {
    static void saySomething() {
        speak("I'm a static method using a private static method");
    }

    static void saySomethingLoud() {
        speak("PRIVATE STATIC METHOD WAS INCLUDED IN JAVA 9");
    }

    private static void speak(String words) {
        System.out.println(words);
    }

    /**
     * Can't invoke this method in static methods
     */
    private void speakMore() {
        System.out.println("No more words to say!");
    }
}
