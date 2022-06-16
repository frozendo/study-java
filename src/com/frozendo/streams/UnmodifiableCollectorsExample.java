package com.frozendo.streams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class UnmodifiableCollectorsExample {

    public static void main(String[] args) {
        UnmodifiableCollectorsExample execute = new UnmodifiableCollectorsExample();
        execute.immutableCollectorBeforeJava10();
        execute.toUnmodifiableListExample();
        execute.toUnmodifiableSetExample();
        execute.toUnmodifiableMapExample();
        execute.toUnmodifiableMapWithDuplicateKeys();
        execute.toUnmodifiableMapMergingFunction();
    }

    private void immutableCollectorBeforeJava10() {
        System.out.println("##### Create unmodifiable list before Java 10 #####");
        var list = buildList(true);
        final List<LocalDate> result = list.stream().
                collect(Collectors
                        .collectingAndThen(Collectors.toList(), List::copyOf));
        System.out.println("List result: " + list);

        try {
            result.add(LocalDate.now());
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable list.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }

        System.out.println();
    }

    private void toUnmodifiableListExample() {
        System.out.println("##### Using toUnmodifiableList #####");
        var list = buildList(true);
        final List<String> result = list.stream()
                .map(d -> d.format(DateTimeFormatter.BASIC_ISO_DATE))
                .collect(Collectors.toUnmodifiableList());
        System.out.println("List result: " + result);

        try {
            result.add(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable list.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }

        System.out.println();
    }

    private void toUnmodifiableSetExample() {
        System.out.println("##### Using toUnmodifiableSet #####");
        var list = buildList(true);
        final Set<String> result = list.stream()
                .map(d -> d.format(DateTimeFormatter.BASIC_ISO_DATE))
                .collect(Collectors.toUnmodifiableSet());
        System.out.println("List result: " + result);



        try {
            result.add(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable set.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }

        System.out.println();
    }

    private void toUnmodifiableMapExample() {
        System.out.println("##### Using toUnmodifiableMap #####");
        var list = buildList(false);
        final Map<String, String> result = list.stream()
                .map(d -> d.format(DateTimeFormatter.BASIC_ISO_DATE))
                .collect(Collectors.toUnmodifiableMap(s -> s.substring(0,6), s -> s));
        System.out.println("List result: " + result);

        try {
            result.put("X", "Try add in immutable collection");
        } catch (UnsupportedOperationException e) {
            System.out.println("Error when try to change unmodifiable map.");
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }

        System.out.println();
    }

    private void toUnmodifiableMapWithDuplicateKeys() {
        System.out.println("##### Using toUnmodifiableMap with duplicate keys #####");
        var list = buildList(true);

        try {
            final Map<String, String> result = list.stream()
                    .map(d -> d.format(DateTimeFormatter.BASIC_ISO_DATE))
                    .collect(Collectors.toUnmodifiableMap(s -> s.substring(4, 6), s -> s));
            System.out.println(result);
        } catch (IllegalStateException e) {
            System.out.println("Duplicates keys in toUnmodifiableMap.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Other exception " + e.getMessage());
        }

        System.out.println();
    }

    private void toUnmodifiableMapMergingFunction() {
        System.out.println("##### Using toUnmodifiableMap with merge function #####");
        var list = buildList(true);
        final Map<String, String> result = list.stream()
                .map(d -> d.format(DateTimeFormatter.BASIC_ISO_DATE))
                .collect(Collectors.toUnmodifiableMap(s -> s.substring(6, 8), s -> s, callMergeFunction()));
        System.out.println("Result of merge: " + result);

        System.out.println();
    }

    private BinaryOperator<String> callMergeFunction() {
        return (s, x) -> {
            if (s.equals(x)) {
                return s.concat(",").concat(x);
            }
            return s;
        };
    }

    private List<LocalDate> buildList(boolean withDuplicates) {
        List<LocalDate> holidays = new ArrayList<>();

        holidays.add(LocalDate.of(2022, 1, 1));
        holidays.add(LocalDate.of(2022, 4, 21));
        holidays.add(LocalDate.of(2022, 5, 1));
        holidays.add(LocalDate.of(2022, 9, 7));
        holidays.add(LocalDate.of(2022, 12, 25));

        if (withDuplicates) {
            holidays.add(LocalDate.of(2022, 9, 7));
            holidays.add(LocalDate.of(2022, 12, 25));
        }

        return holidays;
    }

}
