package com.frozendo.java16.patternmatch;

import com.frozendo.java16.patternmatch.entities.Circle;
import com.frozendo.java16.patternmatch.entities.Rectangle;
import com.frozendo.java16.patternmatch.entities.Shape;
import com.frozendo.java16.patternmatch.entities.Square;

public class InstanceOfRepeatVariableName {

    public static void main(String[] args) {
        Shape shape = new Rectangle(20, 10);
        System.out.println("The perimeter is: " + getPerimeter(shape));
        System.out.println();

        shape = new Square(10);
        System.out.println("The perimeter is: " + getPerimeter(shape));
        System.out.println();

        shape = new Circle(8);
        System.out.println("The perimeter  is: " + getPerimeter(shape));
        System.out.println();
    }

    public static double getPerimeter(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle convertedShape) {
            System.out.println("Calculate the perimeter of rectangle");
            return 2 * (convertedShape.getLength() + convertedShape.getWidth());
        } else if (shape instanceof Square convertedShape) {
            System.out.println("Calculate the perimeter of square");
            return 4 * convertedShape.getSize();
        } else if (shape instanceof Circle convertedShape) {
            System.out.println("Calculate the perimeter of circle");
            return 2 * convertedShape.getRadius() * Math.PI;
        }
        throw new IllegalArgumentException("Unrecognized shape");
    }
}
