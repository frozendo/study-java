package com.frozendo.java9.interfacemethods;

public interface SomeInterface {

    default String talkAboutMyself() {
        String initialMsg = initialValue();
        return changeToUppercase(initialMsg + "I'm a interface default method");
    }

    default String greet(String name) {
        String initialMsg = initialValue();
        return changeToUppercase(initialMsg + "Hello " + name + " nice to meet you");
    }

    private String changeToUppercase(String msg) {
        return msg.toUpperCase();
    }

    /**
     * Static method can be invoked in static and no static method
     */
    private static String initialValue() {
        return "Private method example: ";
    }

    /**
     * private methods should have a body
     */
    //private int abstractMethod(int x);
}
