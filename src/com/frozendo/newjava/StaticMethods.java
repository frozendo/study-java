package com.frozendo.newjava;

public interface StaticMethods {

    static void main(String[] args) {
        StaticMethods.printByStaticMethods();
        SomeInterfaceStaticMethod.exampleStaticMethod();
        SomeClassStaticMethod.exampleStaticMethod();
    }

    static void printByStaticMethods() {
        System.out.println("Run Interface Static Methods");
    }

}

interface SomeInterfaceStaticMethod {
    static void exampleStaticMethod() {
        System.out.println("Interface static method");
    }
}

class SomeClassStaticMethod implements SomeInterfaceStaticMethod {
    public static void exampleStaticMethod() {
        System.out.println("Class static method");
    }
}
