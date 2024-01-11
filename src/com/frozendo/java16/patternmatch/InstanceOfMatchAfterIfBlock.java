package com.frozendo.java16.patternmatch;

import com.frozendo.java16.patternmatch.entities.Circle;
import com.frozendo.java16.patternmatch.entities.Rectangle;
import com.frozendo.java16.patternmatch.entities.Shape;
import com.frozendo.java16.patternmatch.entities.Square;

public class InstanceOfMatchAfterIfBlock {

    public static void main(String[] args) {
        Shape shape = new Rectangle(20, 10);
        System.out.println("The perimeter is: " + getSquarePerimeter(shape));
        System.out.println();

        shape = new Square(10);
        System.out.println("The perimeter is: " + getSquarePerimeter(shape));
        System.out.println();

        shape = new Circle(8);
        System.out.println("The perimeter  is: " + getSquarePerimeter(shape));
        System.out.println();
    }

    public static double getSquarePerimeter(Shape shape) throws IllegalArgumentException {
        if (!(shape instanceof Square square)) {
            System.out.println("The shape is not a square");
            return 0;
        }
        System.out.println("The shape is a square, get the perimeter");
        return 4 * square.getSize();
    }
}
