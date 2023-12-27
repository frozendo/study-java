package com.frozendo.java8.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee {
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

    public static List<Employee> buildList() {
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
}
