package com.frozendo.java8.interfacemethods;

public class DefaultMethod {

    public static void main(String[] args) {
        EnglishInterface englishObject = new EnglishClass();
        System.out.println(englishObject.saySomething());
        System.out.println(englishObject.screamSomething());
        System.out.println(englishObject.helloWorldLanguage());

        PortugueseInterface portugueseObject = new PortugueseClass();
        System.out.println(portugueseObject.saySomething());
        System.out.println(portugueseObject.screamSomething());
        System.out.println(portugueseObject.helloWorldLanguage());
    }

}

interface EnglishInterface {

    default String saySomething() {
        return "Saying something in english!";
    }

    default String screamSomething() {
        return "This method will never execute";
    }

    default String helloWorldLanguage() {
        return "Hello World";
    }

}

interface PortugueseInterface extends EnglishInterface {

    @Override
    default String screamSomething() {
        return "GRITANDO EM PORTUGUÊS";
    }

    //transform default method from EnglishInterface in a common method
    @Override
    String helloWorldLanguage();

}

class EnglishClass implements EnglishInterface {
    @Override
    public String screamSomething() {
        return "SCREAMING IN ENGLISH";
    }
}

class PortugueseClass implements PortugueseInterface {

    @Override
    public String helloWorldLanguage() {
        return "Olá mundo";
    }

}
