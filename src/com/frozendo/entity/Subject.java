package com.frozendo.entity;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class Subject {
    private final String name;
    private final Double grade;
    private final Integer minimumGradeToPass;

    public Subject(String name, Double grade) {
        var df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        var formatGrade = df.format(grade).replace(",", ".");

        this.name = name;
        this.grade = Double.valueOf(formatGrade);
        this.minimumGradeToPass =createMinimumGrade();
    }

    public String getName() {
        return name;
    }

    public Double getGrade() {
        return grade;
    }

    public Integer getMinimumGradeToPass() {
        return minimumGradeToPass;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    private int createMinimumGrade() {
        double randNumber = Math.random();
        randNumber = (randNumber * 4) + 3;

        return (int)randNumber;
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
