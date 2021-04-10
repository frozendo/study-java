package com.frozendo.lambda;

import com.frozendo.lambda.entity.Produto;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferenceExamples {

    public static void main(String[] args) {
        List<Produto> list = Produto.buildList();
        MethodReferenceExamples example = new MethodReferenceExamples();
        example.methodReferenceStatic(list);
        example.methodReferenceForObject(list);
        example.methodReferenceParticularType(list);
        example.methodReferenceConstructor(list);
    }

    private void methodReferenceStatic(List<Produto> list) {
        System.out.println("##### Usando método estático #####");

        list.forEach(MethodReferenceExamples::printProduto);
        list.stream().map(item -> item.getId()).forEach(Long::toBinaryString);

        System.out.println();
    }

    private void methodReferenceForObject(List<Produto> list) {
        System.out.println("##### Usando objeto #####");

        ProdutoComparator comparator = new ProdutoComparator();
        list.stream().sorted(comparator::compare).forEach(System.out::println);

        System.out.println();
    }

    private void methodReferenceParticularType(List<Produto> list) {
        System.out.println("##### Usando método instância de um objeto #####");

        list.stream().map(Produto::getNome).forEach(System.out::println);
        list.stream().map(Produto::getPreco).forEach(System.out::println);

        System.out.println();
    }

    private void methodReferenceConstructor(List<Produto> list) {
        System.out.println("##### Usando construtor com method reference #####");

        Supplier<Produto> supplier = Produto::new;

        System.out.println(supplier.get());
        System.out.println(supplier.get());

        System.out.println();
    }

    private static void printProduto(Produto produto) {
        System.out.println(produto);
    }

    private class ProdutoComparator implements Comparator<Produto> {
        @Override
        public int compare(Produto o1, Produto o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }

}
