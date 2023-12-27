package com.frozendo.java8.lambda.bifunctions;

import com.frozendo.entity.Product;

import java.util.List;
import java.util.function.BiFunction;

public class LambdaBiFunction {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        BiFunction<Product, String, String> function =
                (exampleObject, toConcat) -> exampleObject.getName().concat(toConcat);

        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            String result = function.apply(product, " - Example " + i);
            System.out.println(result);
        }
    }

}
