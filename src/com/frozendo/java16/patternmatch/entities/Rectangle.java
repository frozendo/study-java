package com.frozendo.java16.patternmatch.entities;

public class Rectangle implements Shape {

    final double length;
    final double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
