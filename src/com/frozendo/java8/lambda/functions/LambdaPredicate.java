package com.frozendo.java8.lambda.functions;

import com.frozendo.java8.entity.Product;

import java.util.List;
import java.util.function.Predicate;

public class LambdaPredicate {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();

        //Predicate function = receive an object and return boolean value
        Predicate<Product> predicate = product -> product.getPrice() > 50;

        list.stream().filter(predicate).forEach(item -> System.out.println(item.getName()));
        System.out.println("There is any product with price bigger than 50 = " + list.stream().anyMatch(predicate));
        System.out.println("No one products have price bigger than 50 = " + list.stream().noneMatch(predicate));
        System.out.println("All products have price bigger than 50 = " + list.stream().allMatch(predicate));
    }

}
