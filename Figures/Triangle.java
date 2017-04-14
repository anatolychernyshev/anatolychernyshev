package com.company;

public class Triangle implements Figure{

    private double result;
    private double sideOne;
    private double sideTwo;
    private double sideThree;

    public void Triangle (double sideOne, double sideTwo, double sideThree){
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    @Override
    public double calculateArea() {
        result = Math.sqrt(calculatePerimeter()*(calculatePerimeter()-sideOne)*(calculatePerimeter()-sideTwo)*(calculatePerimeter()-sideThree));
        return result;
    }

    @Override
    public double calculatePerimeter() {
        result = sideOne + sideTwo + sideThree;
        return result;
    }
}
