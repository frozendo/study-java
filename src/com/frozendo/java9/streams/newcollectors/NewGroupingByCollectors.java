package com.frozendo.java9.streams.newcollectors;

import com.frozendo.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewGroupingByCollectors {

    public static void main(String[] args) {
        groupingBySquadWithoutFilter();
        groupingBySquadAndFilterWithStreamMethod();
        groupingBySquadAndFilterWithNewCollector();
    }

    private static void groupingBySquadWithoutFilter() {
        List<Employee> employees = Employee.buildList();
        System.out.println("Grouping by squad without filter");

        Map<String, List<Employee>> values = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSquad));

        Map<String, Long> counting = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSquad, Collectors.counting()));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

    private static void groupingBySquadAndFilterWithStreamMethod() {
        System.out.println("Grouping by squad and filter before grouping");
        List<Employee> employees = Employee.buildList();

        Map<String, List<Employee>> values = employees.stream()
                .filter(i -> i.getSalary() > 5000D)
                .collect(Collectors.groupingBy(Employee::getSquad));

        Map<String, Long> counting = employees.stream()
                .filter(i -> i.getSalary() > 5000D)
                .collect(Collectors.groupingBy(Employee::getSquad, Collectors.counting()));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

    private static void groupingBySquadAndFilterWithNewCollector() {
        System.out.println("Grouping by squad and filter after grouping");
        List<Employee> employees = Employee.buildList();

        Map<String, List<Employee>> values = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSquad,
                        Collectors.filtering(i -> i.getSalary() > 5000D, Collectors.toList())));

        Map<String, Long> counting = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSquad,
                        Collectors.filtering(i -> i.getSalary() > 5000D, Collectors.counting())));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

}
