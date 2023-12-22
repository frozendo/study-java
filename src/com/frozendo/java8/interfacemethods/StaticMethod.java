package com.frozendo.java8.interfacemethods;

public interface StaticMethod {

    static void main(String[] args) {
        StaticMethod.runMainMethodOnInterface();
        EnglishInterfaceStaticMethod.helloWorldStaticMethod();
        EnglishClassStaticMethod.helloWorldStaticMethod();
    }

    static void runMainMethodOnInterface() {
        System.out.println("Run main method on an interface");
    }

}

interface EnglishInterfaceStaticMethod {
    static void helloWorldStaticMethod() {
        System.out.println("Hello World from an interface");
    }
}

class EnglishClassStaticMethod implements EnglishInterfaceStaticMethod {
    public static void helloWorldStaticMethod() {
        System.out.println("Hello World from a class");
    }
}
