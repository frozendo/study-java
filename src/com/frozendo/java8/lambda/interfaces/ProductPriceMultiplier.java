package com.frozendo.java8.lambda.interfaces;

import com.frozendo.java8.entity.Product;

@FunctionalInterface
public interface ProductPriceMultiplier {

    Double apply(Product product, Double multiplier);

}
