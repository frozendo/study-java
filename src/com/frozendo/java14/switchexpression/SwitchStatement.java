package com.frozendo.java14.switchexpression;

import com.frozendo.entity.Subject;

import java.util.Random;

public class SwitchStatement {

    public static void main(String[] args) {

        var list = Subject.buildSubjectsAndGradeList();
        var randomNumber = new Random().nextInt(4);

        var randomSubject = list.get(randomNumber);
        var minimumGradeToPass = randomSubject.getMinimumGradeToPass();

        String result;

        switch (minimumGradeToPass) {
            case 3: result = "The minimum grade to pass in %s is = 3"; break;
            case 4: result = "The minimum grade to pass in %s is = 4"; break;
            case 5: result = "The minimum grade to pass in %s is = 5"; break;
            case 6: result = "The minimum grade to pass in %s is = 6"; break;
            case 7: result = "The minimum grade to pass in %s is = 7"; break;
            default: result = "The minimum grade to pass is not of your business"; break;
        }

        System.out.println(result.formatted(randomSubject.getName()));

    }

}
