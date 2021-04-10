package com.frozendo.lambda.interfaces;

@FunctionalInterface
public interface NumberProcess<T> {

    T apply(T value1, T value2);

    /**
     * Removendo o comentário desse método, temos erro de compilação
     * por conta da anotação @FunctionalInterface
     */
    //void calculate(T value1, T value2);

}
