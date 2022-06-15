package com.frozendo.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateParallelStreamsExamples {

    public static void main(String[] args) {
        CreateParallelStreamsExamples execute = new CreateParallelStreamsExamples();

        execute.createParallelStreamFromCollection();
        execute.executeStreamInParallelAndSequential();
        execute.checkSequentialAndParallel();
    }

    private void createParallelStreamFromCollection() {
        System.out.println("##### Execute collections in parallel stream #####");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.print("output = ");
        list.parallelStream().forEach(System.out::print);
        System.out.println();
        System.out.println();
    }

    private void executeStreamInParallelAndSequential() {
        System.out.println("##### Execute a parallel and a sequential stream with same values #####");
        Stream<Integer> toParallel = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .parallel();
        Stream<Integer> toSequential = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .parallel();

        System.out.print("Execute stream parallel = ");
        toParallel.forEach(System.out::print);
        System.out.println();

        System.out.print("Execute stream sequential = ");
        toSequential.sequential().forEach(System.out::print);
        System.out.println();
        System.out.println();
    }

    private void checkSequentialAndParallel() {
        System.out.println("##### Compare parallel and sequential stream #####");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> sequential = list.stream();
        Stream<Integer> parallel = list.parallelStream();

        System.out.println("sequential is parallel? = " + sequential.isParallel());
        System.out.println("parallel is parallel? = " + parallel.isParallel());
    }

}
