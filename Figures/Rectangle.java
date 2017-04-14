package com.company;


public class Rectangle implements Figure{
    private double result;
    private double sideOne;
    private double sideTwo;

    public Rectangle(double sideOne,double sideTwo) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    @Override
    public double calculateArea() {
        result = sideOne * sideTwo;
        return result;
    }

    @Override
    public double calculatePerimeter() {
        result = (sideOne + sideTwo) * 2;
        return result;
    }
}
