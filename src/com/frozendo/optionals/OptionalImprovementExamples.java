package com.frozendo.optionals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalImprovementExamples {

    public static void main(String[] args) {
        OptionalImprovementExamples execute = new OptionalImprovementExamples();
        execute.orExamples();
        execute.ifPresentOrElseExample();
        execute.optionalStreamExample();
    }

    private void orExamples() {
        System.out.println("##### OR method examples ######");

        System.out.println("Optional with value");
        Optional<LocalDate> original = Optional.of(LocalDate.of(2016, 12, 3));
        Optional<LocalDate> optEmpty = Optional.empty();
        Optional<LocalDate> resultOpt = original.or(() -> optEmpty);
        System.out.println("Result: " + resultOpt);
        System.out.println("Instance is equal?: " + (resultOpt == original));

        System.out.println();

        System.out.println("Optional empty");
        Optional<LocalDate> empty = Optional.empty();
        Optional<LocalDate> resultEmpty = empty.or(buildLocalDate());
        System.out.println("Result: " + resultEmpty);
        System.out.println("Instance is equal?: " + (resultEmpty == empty));

        System.out.println();

        System.out.println("Parameter null");
        try {
            Optional<LocalDate> resultExcp = original.or(null);
            System.out.println("Result: " + resultExcp);
            System.out.println("Instance is equal?: " + (resultExcp == original));
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException in method 'or'");
        } catch (Exception ex) {
            System.out.println("Other exception " + ex.getMessage());
        }

        System.out.println();
    }

    private void ifPresentOrElseExample() {
        System.out.println("##### ifPresentOrElse method examples ######");

        System.out.println("Compare ifPresent and ifPresentOrElse");
        Optional<LocalDate> value = Optional.of(LocalDate.of(2009, 11, 30));
        value.ifPresent(
                ld -> System.out.println("Using ifPresent: " + ld.format(DateTimeFormatter.BASIC_ISO_DATE)));
        value.ifPresentOrElse(
                ld -> System.out.println("Using ifPresentOrElse: " + ld.format(DateTimeFormatter.ISO_DATE)),
                LocalDate::now);

        System.out.println();

        System.out.println("When optional is empty");
        Optional<LocalDate> empty = Optional.empty();
        empty.ifPresent(
                ld -> System.out.println("Using ifPresent: " + ld));
        empty.ifPresentOrElse(
                ld -> System.out.println("Using ifPresentOrElse: " + ld),
                () -> System.out.println("Execute orElse function: " + LocalDate.now()));

        System.out.println();

        System.out.println("Pass consumer null");
        Optional<LocalDate> consumerNull = Optional.of(LocalDate.of(2019, 6, 10));

        try {
            consumerNull.ifPresentOrElse(
                    null,
                    () -> System.out.println("Execute orElse function: " + LocalDate.now()));
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException in method 'ifPresentOrElse'");
        } catch (Exception ex) {
            System.out.println("Other exception " + ex.getMessage());
        }

        System.out.println();
    }

    private void optionalStreamExample() {
        System.out.println("##### stream method examples ######");

        System.out.println("Basic use");
        Optional<LocalDate> oldDate = Optional.of(LocalDate.of(2017, 7, 1));
        final List<LocalDate> collect = oldDate.stream()
                .collect(Collectors.toList());
        System.out.println("Optional value in a list: " + collect);

        System.out.println();

        System.out.println("Use with Stream<Optional> list");
        Stream<OptionalInt> values = Stream.of(OptionalInt.of(10), OptionalInt.of(20),
                OptionalInt.of(30), OptionalInt.of(40));

        final int sum = values.flatMapToInt(OptionalInt::stream).sum();
        System.out.println("Optional values sum: " + sum);

        System.out.println();
    }

    private Supplier<Optional<LocalDate>> buildLocalDate() {
        return () -> Optional.of(LocalDate.now());
    }

}
