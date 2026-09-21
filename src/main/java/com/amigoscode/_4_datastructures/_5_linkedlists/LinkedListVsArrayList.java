package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListVsArrayList {

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) linkedList.add(0, i);
        long llBegin = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) arrayList.add(0, i);
        long alBegin = System.nanoTime() - start;

        System.out.printf("LinkedList head insertion took %.4f ms\n", llBegin/1_000_000.0);
        System.out.printf("ArrayList head insertion took %.4f ms\n", alBegin/1_000_000.0);
        System.out.println();



        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) linkedList.add(i);
        long llEnd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) arrayList.add(i);
        long alEnd = System.nanoTime() - start;

        System.out.printf("LinkedList tail insertion took %.4f ms\n", llEnd/1_000_000.0);
        System.out.printf("ArrayList tail insertion took %.4f ms\n", alEnd/1_000_000.0);
        System.out.println();



        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
        start = System.nanoTime();
        int midIndex = linkedList.size()/2;
        for (int i = 0; i < 1000 ; i++) linkedList.get(midIndex);
        long llGet = System.nanoTime() - start;

        start = System.nanoTime();
        midIndex = arrayList.size()/2;
        for (int i = 0; i < 1000; i++) arrayList.get(midIndex);
        long alGet = System.nanoTime() - start;

        System.out.printf("LinkedList middle index fetch took %.4f ms\n", llGet/1_000_000.0);
        System.out.printf("ArrayList middle index fetch took %.4f ms\n", alGet/1_000_000.0);
        System.out.println();


        // TODO: 5 - Print a summary explaining the differences
        //           Use System.out.println() to explain:
        //           - Why LinkedList is faster for insertions at the beginning
        //           - Why ArrayList is faster for random access (get by index)
        //           - When you would choose one over the other
        System.out.println("Summary");
        System.out.println("LinkedLists creates a node and has the former head point to the new node as the previous node, " +
                "ArrayList shifts all existing elements to make room for the new head");
        System.out.println("ArrayLists use arrays and so they use direct access via index, " +
                "LinkedLists go through all nodes till they get to the specified node");
        System.out.println("Choose LinkedLists when you frequently add/remove elements at the beginning, " +
                "Choose ArrayLists when you need fast random access");
    }
}
