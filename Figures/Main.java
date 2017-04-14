package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("What do u want to calculate?");
            String firstIn = bufferedReader.readLine();
            try {
                switch (firstIn) {
                    case "Square":
                        System.out.println("Enter the side of square:");
                        double sideOneSquare = Double.parseDouble(bufferedReader.readLine());
                        double sideTwoSquare = sideOneSquare;
                        Rectangle rectangleSquare = new Rectangle(sideOneSquare, sideTwoSquare);
                        System.out.println("Area of square = " + rectangleSquare.calculateArea() + "\n" + "Perimeter of square = " + rectangleSquare.calculatePerimeter());
                        break;
                    case "Rectangle":
                        System.out.println("So, enter the sides of rectangle:");
                        double sideOneRectangle = Double.parseDouble(bufferedReader.readLine());
                        double sideTwoRectangle = Double.parseDouble(bufferedReader.readLine());
                        Rectangle rectangle = new Rectangle(sideOneRectangle, sideTwoRectangle);
                        System.out.println("Area of rectangle = " + rectangle.calculateArea() + "\n" + "Perimeter of rectangle = " + rectangle.calculatePerimeter());
                        break;
                    case "Circle":
                        System.out.println("So, enter the radius of circle:");
                        double radiusCircle = Double.parseDouble(bufferedReader.readLine());
                        Circle circle = new Circle(radiusCircle);
                        System.out.println("Area of circle = " + circle.calculateArea() + "\n" + "The length of circle = " + circle.calculatePerimeter());
                        break;
                    case "Triangle":
                        System.out.println("So, enter the sides of rectangle:");
                        Triangle triangle = new Triangle();
                        double sideOneTriangle = Double.parseDouble(bufferedReader.readLine());
                        double sideTwoTriangle = Double.parseDouble(bufferedReader.readLine());
                        double sideThreeTriangle = Double.parseDouble(bufferedReader.readLine());
                        triangle.Triangle(sideOneTriangle, sideTwoTriangle, sideThreeTriangle);
                        System.out.println("Area of rectangle = " + triangle.calculateArea() + "\n" + "Perimeter of rectangle = " + triangle.calculatePerimeter());
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter the number!");
            }
        }
    }

}

