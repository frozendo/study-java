package com.frozendo.java16.patternmatch;

import com.frozendo.java16.patternmatch.entities.Circle;
import com.frozendo.java16.patternmatch.entities.Rectangle;
import com.frozendo.java16.patternmatch.entities.Shape;
import com.frozendo.java16.patternmatch.entities.Square;

public class InstanceOfOldWay {

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
        if (shape instanceof Rectangle) {
            System.out.println("Calculate the perimeter of rectangle");
            Rectangle rectangle = (Rectangle) shape;
            return 2 * (rectangle.getLength() + rectangle.getWidth());
        } else if (shape instanceof Square) {
            System.out.println("Calculate the perimeter of square");
            Square square = (Square) shape;
            return 4 * square.getSize();
        } else if (shape instanceof Circle) {
            System.out.println("Calculate the perimeter of circle");
            Circle circle = (Circle) shape;
            return 2 * circle.getRadius() * Math.PI;
        }

        throw new IllegalArgumentException("Unrecognized shape");
    }

}
