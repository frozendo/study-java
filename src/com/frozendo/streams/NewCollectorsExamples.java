package com.frozendo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NewCollectorsExamples {

    public static void main(String[] args) {

        NewCollectorsExamples execute = new NewCollectorsExamples();
        List<Employee> employees = execute.buildList();

        execute.groupingBySquadWithoutFilter(employees);
        execute.groupingBySquadAndFilterBefore(employees);
        execute.groupingBySquadAndFilterAfter(employees);

        execute.partitioningByOutsourced(employees);
        execute.partitioningSkillsOutsourced(employees);

    }

    private void groupingBySquadWithoutFilter(List<Employee> employees) {
        System.out.println("##### Grouping by squad without filter #####");

        Map<String, List<Employee>> values = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSquad));

        Map<String, Long> counting = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSquad, Collectors.counting()));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

    private void groupingBySquadAndFilterBefore(List<Employee> employees) {
        System.out.println("##### Grouping by squad and filter before grouping #####");

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

    private void groupingBySquadAndFilterAfter(List<Employee> employees) {
        System.out.println("##### Grouping by squad and filter after grouping #####");

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

    private void partitioningByOutsourced(List<Employee> employees) {
        System.out.println("##### Partitioning employees by outsourced #####");

        Map<Boolean, List<Employee>> values = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isOutsourced));

        Map<Boolean, Long> counting = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isOutsourced, Collectors.counting()));

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

    private void partitioningSkillsOutsourced(List<Employee> employees) {
        System.out.println("##### Partitioning skills by outsourced #####");

        Map<Boolean, Set<String>> values = employees.stream()
                .collect(
                        Collectors.partitioningBy(Employee::isOutsourced,
                                Collectors.flatMapping(e -> e.getSkills().stream(), Collectors.toSet())));

        Map<Boolean, Long> counting = employees.stream()
                .collect(
                        Collectors.partitioningBy(Employee::isOutsourced,
                                Collectors.flatMapping(e -> e.getSkills().stream(), Collectors.counting())));;

        System.out.println("group values=" + values);
        System.out.println("group count=" + counting);

        System.out.println();
    }

    private List<Employee> buildList() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Rogério", "credit", 4700D, true, List.of("rabbit", "spring")));
        employees.add(new Employee("Valentina", "credit", 7000D, false, List.of("kafka", "microservices")));
        employees.add(new Employee("Miguel", "credit", 6500D, false, List.of("microservices", "rabbit")));
        employees.add(new Employee("Raul", "transfer", 6000D, true, List.of("spring", "kafka")));
        employees.add(new Employee("Sueli", "transfer", 5500D, false, List.of("rabbit", "kafka")));
        employees.add(new Employee("Fernanda", "transfer", 4500D, true, List.of("kafka", "spring")));
        employees.add(new Employee("Marta", "pix", 5000D, true, List.of("spring", "kafka")));
        employees.add(new Employee("Marcos", "pix", 4900D, true, List.of("rabbit", "spring")));

        return employees;
    }

    private class Employee {
        private String name;
        private String squad;
        private Double salary;
        private boolean isOutsourced;

        private List<String> skills;

        public Employee(String name, String squad, Double salary, boolean isOutsourced, List<String> skills) {
            this.name = name;
            this.squad = squad;
            this.salary = salary;
            this.isOutsourced = isOutsourced;
            this.skills = skills;
        }

        public String getName() {
            return name;
        }

        public String getSquad() {
            return squad;
        }

        public Double getSalary() {
            return salary;
        }

        public boolean isOutsourced() {
            return isOutsourced;
        }

        public List<String> getSkills() {
            return skills;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", squad='" + squad + '\'' +
                    ", salary=" + salary +
                    ", isOutsourced=" + isOutsourced +
                    ", skills=" + skills +
                    '}';
        }
    }

}
