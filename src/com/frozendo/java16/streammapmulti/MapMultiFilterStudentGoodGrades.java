package com.frozendo.java16.streammapmulti;

import com.frozendo.entity.Student;

public class MapMultiFilterStudentGoodGrades {

    public static void main(String[] args) {
        final var students = Student.buildStudentList();

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
    }

}
