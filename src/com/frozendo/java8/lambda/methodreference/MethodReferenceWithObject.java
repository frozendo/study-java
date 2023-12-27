package com.frozendo.java8.lambda.methodreference;

import com.frozendo.entity.Product;

import java.util.Comparator;
import java.util.List;

public class MethodReferenceWithObject {

    public static void main(String[] args) {
        MethodReferenceWithObject methodReferenceWithObject = new MethodReferenceWithObject();
        methodReferenceWithObject.executeExample();
    }

    private void executeExample() {
        List<Product> list = Product.buildList();
        ProductComparator comparator = new ProductComparator();

        //call to different methods using method reference with object
        list.stream()
                .sorted(comparator::compare)
                .forEach(System.out::println);
    }

    private class ProductComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
