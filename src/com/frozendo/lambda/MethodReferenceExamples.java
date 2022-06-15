package com.frozendo.lambda;

import com.frozendo.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferenceExamples {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        MethodReferenceExamples execute = new MethodReferenceExamples();
        execute.methodReferenceStatic(list);
        execute.methodReferenceForObject(list);
        execute.methodReferenceParticularType(list);
        execute.methodReferenceConstructor(list);
    }

    private void methodReferenceStatic(List<Product> list) {
        System.out.println("##### Using static methods #####");

        list.forEach(MethodReferenceExamples::printProduct);
        list.stream().map(item -> item.getId()).forEach(Long::toBinaryString);

        System.out.println();
    }

    private void methodReferenceForObject(List<Product> list) {
        System.out.println("##### Using method reference with object #####");

        ProductComparator comparator = new ProductComparator();
        list.stream().sorted(comparator::compare).forEach(System.out::println);

        System.out.println();
    }

    private void methodReferenceParticularType(List<Product> list) {
        System.out.println("##### Using object instance method #####");

        System.out.println("Product name");
        list.stream().map(Product::getName).forEach(System.out::println);

        System.out.println();

        System.out.println("Product price");
        list.stream().map(Product::getPrice).forEach(System.out::println);

        System.out.println();
    }

    private void methodReferenceConstructor(List<Product> list) {
        System.out.println("##### Using constructor with method reference #####");

        Supplier<Product> supplier = Product::new;

        System.out.println(supplier.get());
        System.out.println(supplier.get());

        System.out.println();
    }

    private static void printProduct(Product product) {
        System.out.println(product);
    }

    private class ProductComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
