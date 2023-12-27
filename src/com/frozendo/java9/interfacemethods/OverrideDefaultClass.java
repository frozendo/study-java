package com.frozendo.java9.interfacemethods;

public class OverrideDefaultClass implements SomeInterface {
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
