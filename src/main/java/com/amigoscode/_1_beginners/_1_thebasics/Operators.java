package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Operators
 *
 * Learn how to use arithmetic, comparison, logical, and other operators in Java.
 * Operators allow you to perform operations on variables and values.
 */
public class Operators {

    public static void main(String[] args) {

        // TODO: 1 - Use arithmetic operators (+, -, *, /) on two int variables and print the results
        // Declare two int variables (e.g., number = 10, b = 3)
        // Print the result of number + b, number - b, number * b, and number / b
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        int diff = num2 - num1;
        int times = num1 * num2;
        int division = num2 / num1;
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(times);
        System.out.println(division);
        System.out.println();


        // TODO: 2 - Use the modulus operator (%) to check if number number is even
        // Declare an int variable called number with any value.
        // Print the result of number % 2
        // Print whether the number is even (result is 0) or odd (result is 1)
        int number = 20004;
        int result = number % 2;
        System.out.println(result);
        String parity = (result == 0) ? "even" : "odd";
        System.out.println(number + " is " + parity);
        System.out.println();


        // TODO: 3 - Use increment (++) and decrement (--) operators
        // Declare an int variable called counter, set it to 5
        // Use counter++ and print the result, then use counter-- and print the result
        int counter = 5;
        counter++;
        System.out.println(counter);
        counter--;
        System.out.println(counter);
        System.out.println();


        // TODO: 4 - Use compound assignment operators (+=, -=, *=)
        // Declare an int variable called score, set it to 10
        // Use +=, -=, and *= on score, printing after each operation
        int score = 10;
        score += 4;
        System.out.println(score);
        score -= 7;
        System.out.println(score);
        score *= 2;
        System.out.println(score);
        System.out.println();


        // TODO: 5 - Use comparison operators (==, !=, >, <, >=, <=) and print the boolean results
        // Declare two int variables (e.g., x = 5, y = 10)
        // Print the result of each comparison, e.g.: System.out.println("x == y: " + (x == y));
        int x = 5;
        int y = 10;
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));
        System.out.println("x < y: " + (x < y));
        System.out.println("x >= y: " + (x >= y));
        System.out.println("x <= y: " + (x <= y));
        System.out.println();


        // TODO: 6 - Use logical operators (&&, ||, !) to combine conditions
        // Print the result of: hasLicense && hasInsurance
        // Declare two boolean variables (e.g., hasLicense = true, hasInsurance = false)
        // Print the result of: hasLicense || hasInsurance
        // Print the result of: !hasLicense
        boolean hasLicense = true;
        boolean hasInsurance = false;
        System.out.println(hasLicense && hasInsurance);
        System.out.println(hasLicense || hasInsurance);
        System.out.println(!hasLicense);
        System.out.println();


        // TODO: 7 - Use the ternary operator to assign "adult" or "minor" based on age
        // Declare an int variable called age with any value
        // Use the ternary operator: String status = (condition) ? "adult" : "minor";
        // Print the status
        int age = 24;
        String status = (age >18) ? "adult" : "minor";
        System.out.println(status);
        System.out.println();

    }
}
