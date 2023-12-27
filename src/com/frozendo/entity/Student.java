package com.frozendo.entity;

import java.util.List;

public class Student {
    private final String name;
    private final List<Subject> subjects;

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects.toString() +
                '}';
    }

    public static List<Student> buildStudentList() {
        return List.of(
                new Student("Enzo", Subject.buildSubjectsAndGradeList()),
                new Student("Valentina", Subject.buildSubjectsAndGradeList()),
                new Student("Lorenzo", Subject.buildSubjectsAndGradeList()),
                new Student("Ana Maria", Subject.buildSubjectsAndGradeList()),
                new Student("Enzo Diogo", Subject.buildSubjectsAndGradeList())
        );
    }
}
