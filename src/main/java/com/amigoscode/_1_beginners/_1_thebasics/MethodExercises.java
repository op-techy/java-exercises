package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Methods
 *
 * Learn how to define and call methods in Java.
 * Methods allow you to organize code into reusable blocks, each performing a specific task.
 */
public class MethodExercises {

    // TODO: 1 - Create a method called greet that takes a String parameter 'name'
    // and prints "Hello, {name}!"
    // Hint: public static void greet(String name) { ... }
    public static void greet (String name){
        System.out.printf("Hello, %s!", name);
        System.out.println();
    }


    // TODO: 2 - Create a method called add that takes two int parameters (a, b)
    // and returns their sum
    // Hint: public static int add(int a, int b) { ... }
    public static int add(int a, int b){
        return a + b;
    }


    // TODO: 3 - Create a method called isEven that takes an int parameter 'number'
    // and returns true if the number is even, false otherwise
    // Hint: Use the modulus operator (%)
    public static boolean isEven(int number){
        return number % 2 == 0;
    }


    // TODO: 4 - Create a method called max that takes two int parameters (a, b)
    // and returns the larger of the two
    // Hint: Use an if statement or the ternary operator
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }


    // TODO: 5 - Create a method called factorial that takes an int parameter 'n'
    // and returns n! (n factorial) using a loop
    // Hint: 5! = 5 * 4 * 3 * 2 * 1 = 120. Use a long return type for larger values.
    public static int factorial (int n){
        int result = 1;
        do{
            result *= n;
            n--;
        }while (n > 0);

        return result;
    }


    // TODO: 6 - Create two overloaded methods called multiply:
    //   - One that takes 2 int parameters and returns their product
    //   - One that takes 3 int parameters and returns their product
    // Overloading means having multiple methods with the same name but different parameters.
    public static int multiply(int a, int b){
        return a * b;

    }
    public static int multiply(int a, int b, int c){
        return a * b * c;
    }


    public static void main(String[] args) {

        // TODO: 7 - Call all the methods above and print their results
        // - Call greet with your name
        greet("Ope");
        // - Call add with two numbers and print the result
        System.out.println(add(2,4));
        // - Call isEven with a number and print whether it is even
        System.out.println(isEven(5));
        // - Call max with two numbers and print the larger one
        System.out.println(max(4,8));
        // - Call factorial with 5 and print the result
        System.out.println(factorial(5));
        // - Call both multiply methods and print their results
        System.out.println(multiply(2,30));
        System.out.println(multiply(2,34,56));

    }
}
