package com.company;

public class Circle implements Figure{
    private double result;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        result = Math.PI * (radius * radius);
        return result;
    }

    @Override
    public double calculatePerimeter() {
        result = 2 * Math.PI * radius;
        return result;
    }
}
