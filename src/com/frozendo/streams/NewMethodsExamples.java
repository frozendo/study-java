package com.frozendo.streams;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class NewMethodsExamples {

    public static void main(String[] args) {
        NewMethodsExamples execute = new NewMethodsExamples();
        execute.getStudentGoodGrades();
        execute.getAverage();
    }

    private void getStudentGoodGrades() {
        System.out.println("##### Use mapMulti to get just good grades #####");

        final var students = buildStudentList();

        System.out.println("Original list:");
        System.out.println(students);

        final var studentsWithGoodGrades = students.stream()
                .mapMulti(((student, consumer) -> {
                    var list = student.getSubjects()
                            .stream()
                            .filter(s -> s.getGrade() > 7.0D)
                            .toList();
                    consumer.accept(new Student(student.getName(), list));
                }))
                .toList();
        System.out.println("Students with goods grades: ");
        System.out.println(studentsWithGoodGrades);
        System.out.println("List type: " + studentsWithGoodGrades.getClass());

        System.out.println();
    }

    private void getAverage() {
        System.out.println("##### Use mapMulti to get average #####");

        final var students = buildStudentList();

        final var studentsAverages = students.stream()
                .mapMulti(((student, consumer) -> {
                    var average = student.getSubjects()
                            .stream()
                            .mapToDouble(Subject::getGrade)
                            .average();
                    var subject = new Subject("Average", average.orElseThrow());
                    consumer.accept(new Student(student.getName(), List.of(subject)));
                }))
                .toList();
        System.out.println("Students averages: ");
        System.out.println(studentsAverages);
        System.out.println("List type: " + studentsAverages.getClass());

        System.out.println();
    }

    private List<Student> buildStudentList() {
        return List.of(
                new Student("Enzo", buildSubjectsAndGradeList()),
                new Student("Valentina", buildSubjectsAndGradeList()),
                new Student("Lorenzo", buildSubjectsAndGradeList()),
                new Student("Ana Maria", buildSubjectsAndGradeList()),
                new Student("Enzo Diogo", buildSubjectsAndGradeList())
        );
    }

    private List<Subject> buildSubjectsAndGradeList() {
        return List.of(
                new Subject("Math", Math.random() * 10.0D),
                new Subject("English", Math.random() * 10.0D),
                new Subject("Science", Math.random() * 10.0D),
                new Subject("Geography", Math.random() * 10.0D)
        );
    }

    private class Student {
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
    }

    private class Subject {
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
    }

}
