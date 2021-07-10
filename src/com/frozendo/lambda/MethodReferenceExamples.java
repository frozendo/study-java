package com.frozendo.lambda;

import com.frozendo.entity.Product;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferenceExamples {

    public static void main(String[] args) {
        List<Product> list = Product.buildList();
        MethodReferenceExamples example = new MethodReferenceExamples();
        example.methodReferenceStatic(list);
        example.methodReferenceForObject(list);
        example.methodReferenceParticularType(list);
        example.methodReferenceConstructor(list);
    }

    private void methodReferenceStatic(List<Product> list) {
        System.out.println("##### Usando método estático #####");

        list.forEach(MethodReferenceExamples::printProduto);
        list.stream().map(item -> item.getId()).forEach(Long::toBinaryString);

        System.out.println();
    }

    private void methodReferenceForObject(List<Product> list) {
        System.out.println("##### Usando objeto #####");

        ProdutoComparator comparator = new ProdutoComparator();
        list.stream().sorted(comparator::compare).forEach(System.out::println);

        System.out.println();
    }

    private void methodReferenceParticularType(List<Product> list) {
        System.out.println("##### Usando método instância de um objeto #####");

        list.stream().map(Product::getNome).forEach(System.out::println);
        list.stream().map(Product::getPreco).forEach(System.out::println);

        System.out.println();
    }

    private void methodReferenceConstructor(List<Product> list) {
        System.out.println("##### Usando construtor com method reference #####");

        Supplier<Product> supplier = Product::new;

        System.out.println(supplier.get());
        System.out.println(supplier.get());

        System.out.println();
    }

    private static void printProduto(Product product) {
        System.out.println(product);
    }

    private class ProdutoComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }

}
