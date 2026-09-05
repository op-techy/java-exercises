package com.amigoscode._3_oop._3_abstractclasses;

/**
 * Exercise: Abstract Classes - Shape
 *
 * Create an abstract Shape class that defines a contract for all shapes.
 * Abstract classes can have both abstract methods (no body — subclasses
 * must implement) and concrete methods (with a body — shared behavior).
 *
 * Key concepts:
 * - Abstract class declaration
 * - Abstract methods (no implementation)
 * - Concrete methods in abstract classes
 * - Forcing subclasses to provide implementations
 */

abstract public class Shape {

    abstract public double area();

    abstract public double perimeter();

    public void describe(){
        System.out.printf("This shape has area: %f and perimeter: %f \n", area(), perimeter());
    }

    @Override
    public String toString() {
        return "Shape{" +
                " area = " +
                String.format("%.2f", area()) +
                ", perimeter = " +
                String.format("%.2f", perimeter()) +
                "}";
    }

}
