package com.frozendo.java16.streammapmulti;

import com.frozendo.entity.Student;
import com.frozendo.entity.Subject;

import java.util.List;

public class MapMultiStudentGradeAverage {

    public static void main(String[] args) {
        final var students = Student.buildStudentList();

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
    }

}
