package com.frozendo.newjava;

public class DefaultMethods {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        System.out.println(someClass.printByDefaultMethod());
        System.out.println(someClass.methodToOverride());
        System.out.println(someClass.overrideToAbstract());

        OtherClass otherClass = new OtherClass();
        System.out.println(otherClass.printByDefaultMethod());
        System.out.println(otherClass.methodToOverride());
        System.out.println(otherClass.overrideToAbstract());


    }

}

interface SomeInterface {
    default String printByDefaultMethod() {
        return "Default method example";
    }

    default String methodToOverride() {
        return "String from interface";
    }

    default String overrideToAbstract() {
        return "Override to Abstract - Some Interface";
    }
}

interface OtherInterface extends SomeInterface {

    default String methodToOverride() {
        return "Override method in other default method";
    }

    //transform default method from SomeInterface in a common method
    String overrideToAbstract();

}

class SomeClass implements SomeInterface {
    public String methodToOverride() {
        return "String from class";
    }
}

class OtherClass implements OtherInterface {

    @Override
    public String overrideToAbstract() {
        return "Method turned in abstract implemented by class";
    }
}

