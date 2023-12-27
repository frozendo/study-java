package com.frozendo.java8.lambda.interfaces;

import com.frozendo.entity.Product;

/**
 * To create a functional interface,
 * we only need a simple interface with a single abstract method
 */
public interface PaidProduct {

    void apply(Product product);

}
