package com.amigoscode._4_datastructures._3_stacks;

// Exercise: Stack Operations
// Learn how to use the Stack data structure - Last In, First Out (LIFO).

import java.util.Stack;

public class StackExercises {

    public static void main(String[] args) {

        // TODO: 1 - Create a Stack of Strings called 'stack'
        Stack<String> stack = new Stack<>();


        // TODO: 2 - Push 5 elements onto the stack: "Java", "Python", "C++", "JavaScript", "Go"
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        stack.push("JavaScript");
        stack.push("Go");


        // TODO: 3 - Peek at the top element without removing it
        //           Print the result (should be "Go")
        System.out.println(stack.peek());

        // TODO: 4 - Pop an element from the stack and print it
        //           Then print the stack to see the remaining elements
        stack.pop();
        System.out.println(stack);

        // TODO: 5 - Check if the stack is empty using isEmpty()
        //           Print the result
        System.out.println(stack.isEmpty());

        // --- String Reversal ---
        System.out.println("\n--- String Reversal ---");
        String original = "Hello World";
        // TODO: 6 - Use a Stack to reverse the string 'original'
        //           Push each character onto a stack, then pop them all to build the reversed string
        //           Print both original and reversed strings
        Stack<Character> chStack = new Stack<>();

        for (int i = 0; i < original.length(); i++) {
            chStack.push(original.charAt(i));
        }

        String reversed = "";

        while (!chStack.isEmpty()){
            reversed += chStack.pop();
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        // --- Balanced Brackets ---
        System.out.println("\n--- Balanced Brackets ---");
        String balanced = "({[()]})";
        String unbalanced = "({[})";
        // TODO: 7 - Implement a balanced brackets checker
        //           Use a Stack to check if a string of brackets is balanced
        //           For each char: if opening bracket, push it; if closing bracket, check
        //           that the top of stack is the matching opening bracket
        //           Test with both 'balanced' and 'unbalanced' strings
        //           Print whether each string is balanced or not
        System.out.println(balanced + " is balanced: " + isBalanced(balanced));
        System.out.println(unbalanced + " is balanced: " + isBalanced(unbalanced));

    }

    static boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){

            if(isOpen(c)){
                stack.push(c);

            } else if (isClosed(c)) {

                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (!matches(top,c)) return false;
            }
        }
        return stack.isEmpty();
    }

    static boolean isOpen(char c){
        return c == '(' || c == '{' || c == '[';
    }

    static boolean isClosed(char c){
        return c == ')' || c == '}' || c == ']';
    }

    static boolean matches (char c, char d){
        return (c == '(' && d == ')')
                || (c == '{' && d == '}')
                || (c == '[' && d == ']');


    }
}
