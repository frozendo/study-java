package com.frozendo.java9.interfacemethods;

public class PrivateMethodInInterface {

    public static void main(String[] args) {
        SimpleClass simpleClass = new SimpleClass();

        System.out.println(simpleClass.talkAboutMyself());
        System.out.println(simpleClass.greet("Ironman"));
        System.out.println();

        OverrideDefaultClass overrideDefaultClass = new OverrideDefaultClass();

        System.out.println(overrideDefaultClass.talkAboutMyself());
        System.out.println(overrideDefaultClass.greet("Black Widow"));
        System.out.println();

        SomeStaticInterface.saySomething();
        SomeStaticInterface.saySomethingLoud();
        System.out.println();
    }

}
