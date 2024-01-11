package com.frozendo.java10.localvariableinference;

import com.frozendo.entity.Product;

public class BasicUsage {

    public static void main(String[] args) {
        var product = Product.bicycle();
        System.out.println("Variable product = " + product);

        /*
        * This operation is not valid, because the variable product can't be changed to an Employee object.
        */
        //product = Employee.buildList().get(0);

        var list = Product.buildList();
        System.out.println("List of products = " + list);

        /*
         * This operation is not valid, because the variable list can't be changed to a Set<Employee> object.
         */
        //list = new HashSet<Product>();
    }

}
