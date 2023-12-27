package com.frozendo.java14.switchexpression;

import com.frozendo.entity.Subject;

import java.util.Random;

public class SwitchExpression {

    public static void main(String[] args) {

        var list = Subject.buildSubjectsAndGradeList();
        var randomNumber = new Random().nextInt(4);

        var randomSubject = list.get(randomNumber);
        var minimumGradeToPass = randomSubject.getMinimumGradeToPass();

        String result = switch (minimumGradeToPass) {
            case 3 -> "The minimum grade to pass in %s is = 3";
            case 4 -> "The minimum grade to pass in %s is = 4";
            case 5 -> "The minimum grade to pass in %s is = 5";
            case 6 -> "The minimum grade to pass in %s is = 6";
            case 7 -> "The minimum grade to pass in %s is = 7";
            default -> "The minimum grade to pass is not of your business";
        };

        System.out.println(result.formatted(randomSubject.getName()));

    }

}
