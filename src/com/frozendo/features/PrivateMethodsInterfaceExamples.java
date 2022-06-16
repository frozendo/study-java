package com.frozendo.features;

public class PrivateMethodsInterfaceExamples {

    public static void main(String[] args) {
        PrivateMethodsInterfaceExamples execute = new PrivateMethodsInterfaceExamples();

        SimpleClass simpleClass = execute.new SimpleClass();

        System.out.println(simpleClass.talkAboutMyself());
        System.out.println(simpleClass.greet("Ironman"));
        System.out.println();

        OverrideDefaultClass overrideDefaultClass = execute.new OverrideDefaultClass();

        System.out.println(overrideDefaultClass.talkAboutMyself());
        System.out.println(overrideDefaultClass.greet("Black Widow"));
        System.out.println();

        SomeStaticInterface.saySomething();
        SomeStaticInterface.saySomethingLoud();
        SomeStaticInterface.speak("Call speak directly");
        System.out.println();

        SayThings sayThings = execute.new SayThings();
        sayThings.saySomething();
        sayThings.saySomethingLoud();
        System.out.println();


    }

    private class SimpleClass implements SomeInterface {

    }

    private class OverrideDefaultClass implements SomeInterface {
        @Override
        public String talkAboutMyself() {
            return "I'm a method in a class that override interface default method";
        }

        /**
         * Produces an error because changeToUppercase cannot be override
         */
//        @Override
//        public int changeToUppercase(int x, int y) {
//            return x * y;
//        }
    }

    private class SayThings implements SomeStaticInterface {
        public void saySomething() {
            //We can't use speak method because it's a private method
            //speak("I'm a static method using a private static method");
            System.out.println("I'm a method in a class");
        }

        public void saySomethingLoud() {
            System.out.println("I'M A METHOD IN A CLASS");
        }
    }

    private interface SomeStaticInterface {

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

    private interface SomeInterface {

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

}
