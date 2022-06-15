package com.frozendo.lambda.interfaces;

@FunctionalInterface
public interface NumberProcess<T> {

    T apply(T value1, T value2);

    /**
     * If we remove this comment, we get a compilation error
     * because of the annotation @FunctionalInterface
     */
    //void calculate(T value1, T value2);

}
