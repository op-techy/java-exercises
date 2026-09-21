package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList Operations
// Learn how to use LinkedList - a doubly-linked list implementation in Java.

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExercises {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.addFirst("First");
        list.addFirst("Second");
        System.out.println(list);

        list.addLast("Third");
        list.addLast("Fourth");
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.removeFirst();
        list.removeLast();
        System.out.println(list);


        // TODO: 6 - Add an element at index 1 using add(index, element): "Inserted"
        //           Print the list to see the element in position
        list.add(1,"Inserted");
        System.out.println(list);


        // TODO: 7 - Iterate using an Iterator and print each element
        //           Use list.iterator() to get the Iterator
        //           Use hasNext() and next() in a while loop
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
