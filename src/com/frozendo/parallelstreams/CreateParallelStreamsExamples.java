package com.frozendo.parallelstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateParallelStreamsExamples {

    public static void main(String[] args) {
        CreateParallelStreamsExamples parallelStreams = new CreateParallelStreamsExamples();

        parallelStreams.createParallelStreamFromCollection();
        parallelStreams.checkSequentialAndParallel();
        parallelStreams.executeStreamInParallelAndSequential();
    }

    public void createParallelStreamFromCollection() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.print("Execute collections in parallel stream = ");
        list.parallelStream().forEach(System.out::print);
        System.out.println();
    }

    public void executeStreamInParallelAndSequential() {
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
    }

    public void checkSequentialAndParallel() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> sequential = list.stream();
        Stream<Integer> parallel = list.parallelStream();

        System.out.println("sequential is parallel? = " + sequential.isParallel());
        System.out.println("parallel is parallel? = " + parallel.isParallel());
    }

}
