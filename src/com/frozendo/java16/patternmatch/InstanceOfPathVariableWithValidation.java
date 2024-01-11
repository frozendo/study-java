package com.frozendo.java16.patternmatch;

import com.frozendo.java16.patternmatch.entities.Circle;
import com.frozendo.java16.patternmatch.entities.Rectangle;
import com.frozendo.java16.patternmatch.entities.Shape;
import com.frozendo.java16.patternmatch.entities.Square;

public class InstanceOfPathVariableWithValidation {

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
        if (shape instanceof Rectangle rectangle && rectangle.getWidth() > 20) {
            System.out.println("Calculate the perimeter of rectangle");
            return 2 * (rectangle.getLength() + rectangle.getWidth());
        } else if (shape instanceof Square square && square.getSize() > 5) {
            System.out.println("Calculate the perimeter of square");
            return 4 * square.getSize();
        } else if (shape instanceof Circle circle && circle.getRadius() > 5) {
            System.out.println("Calculate the perimeter of circle");
            return 2 * circle.getRadius() * Math.PI;
        }
        System.out.println("Not execute any math");
        return 0;
    }
}
