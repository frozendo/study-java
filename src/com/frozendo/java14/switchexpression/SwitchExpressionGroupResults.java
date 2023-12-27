package com.frozendo.java14.switchexpression;

import com.frozendo.entity.Subject;

import java.util.Random;

public class SwitchExpressionGroupResults {

    public static void main(String[] args) {
        var list = Subject.buildSubjectsAndGradeList();
        var randomNumber = new Random().nextInt(4);

        var randomSubject = list.get(randomNumber);
        var minimumGradeToPass = randomSubject.getMinimumGradeToPass();

        String result = switch (minimumGradeToPass) {
            case 3,4,5 -> "To easy to pass in %s";
            case 6,7 -> "To hard to pass in %s";
            default -> "WTF!";
        };

        System.out.println(result.formatted(randomSubject.getName()));
    }

}
