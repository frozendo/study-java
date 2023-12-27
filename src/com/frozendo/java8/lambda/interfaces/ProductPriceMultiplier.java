package com.frozendo.java8.lambda.interfaces;

import com.frozendo.entity.Product;

@FunctionalInterface
public interface ProductPriceMultiplier {

    Double apply(Product product, Double multiplier);

}
