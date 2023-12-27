package com.frozendo.java9.streams.newcollectors;

import com.frozendo.java8.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NewPartitioningByCollectors {

    public static void main(String[] args) {
        partitioningByOutsourced();
        partitioningSkillsOutsourced();
    }

    private static void partitioningByOutsourced() {
        System.out.println("Partitioning employees by outsourced");
        List<Employee> employees = Employee.buildList();

        Map<Boolean, List<Employee>> values = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isOutsourced));

        Map<Boolean, Long> counting = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isOutsourced, Collectors.counting()));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

    private static void partitioningSkillsOutsourced() {
        System.out.println("Partitioning skills by outsourced");
        List<Employee> employees = Employee.buildList();

        Map<Boolean, Set<String>> values = employees.stream()
                .collect(
                        Collectors.partitioningBy(Employee::isOutsourced,
                                Collectors.flatMapping(e -> e.getSkills().stream(), Collectors.toSet())));

        Map<Boolean, Long> counting = employees.stream()
                .collect(
                        Collectors.partitioningBy(Employee::isOutsourced,
                                Collectors.flatMapping(e -> e.getSkills().stream(), Collectors.counting())));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

}
