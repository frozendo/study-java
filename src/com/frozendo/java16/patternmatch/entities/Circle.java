package com.frozendo.java16.patternmatch.entities;

public class Circle implements Shape {
    final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
