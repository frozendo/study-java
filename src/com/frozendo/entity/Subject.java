package com.frozendo.entity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class Subject {
    private final String name;
    private final Double grade;

    public Subject(String name, Double grade) {
        var df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        var formatGrade = df.format(grade).replace(",", ".");

        this.name = name;
        this.grade = Double.valueOf(formatGrade);
    }

    public String getName() {
        return name;
    }

    public Double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public static List<Subject> buildSubjectsAndGradeList() {
        return List.of(
                new Subject("Math", Math.random() * 10.0D),
                new Subject("English", Math.random() * 10.0D),
                new Subject("Science", Math.random() * 10.0D),
                new Subject("Geography", Math.random() * 10.0D)
        );
    }
}
