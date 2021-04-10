package com.frozendo.lambda;

import com.frozendo.lambda.entity.Produto;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;
import java.util.function.LongToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.UnaryOperator;

public class SpecialFunctionsExamples {

    public static void main(String[] args) {

        Produto produto = new Produto();

        System.out.println("##### UnaryOperator example #####");
        UnaryOperator<String> unaryOperator = value -> value.toUpperCase();
        String unaryOut = unaryOperator.apply(produto.getNome());
        System.out.println("Unary Output = " + unaryOut);
        System.out.println();

        System.out.println("##### BinaryOperator example #####");
        BinaryOperator<BigDecimal> binaryOperator = (value1, value2) -> value1.add(value2);
        System.out.println("Binary Output = " + binaryOperator.apply(BigDecimal.TEN, BigDecimal.valueOf(10)));
        System.out.println();

        System.out.println("##### LongToIntFunction example #####");
        LongToIntFunction longToIntFunction = value -> (int) value;
        System.out.println("To Int Output = " + longToIntFunction.applyAsInt(10L));
        System.out.println();

        System.out.println("##### ToLongBiFunction example #####");
        ToLongBiFunction<Double, Integer> toLongBiFunction = (value1, value2) -> value1.longValue() + value2;
        System.out.println("To Long Output = " + toLongBiFunction.applyAsLong(20.0, 10));
        System.out.println();

    }
}
