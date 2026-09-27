package com.amigoscode._5_generics._4_genericmethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    // TODO: 1 - Create a static generic method: <T> void printArray(T[] array)
    //  It should print each element of the array on the same line separated
    //  by spaces, then print a newline at the end.
    static <T> void printArray(T[] array){
        for(T object : array){
            System.out.print(object + " ");
        }
        System.out.println();
    }

    // TODO: 2 - Create a static generic method: <T> T getFirst(List<T> list)
    //  It should return the first element of the list.
    //  If the list is empty, return null.
    static <T> T getFirst(List<T> list){
        return list.isEmpty() ? null : list.getFirst();
    }

    // TODO: 3 - Create a static generic method: <T> T getLast(List<T> list)
    //  It should return the last element of the list.
    //  If the list is empty, return null.
    static <T> T getLast(List<T> list){
        return list.isEmpty() ? null : list.getLast();
    }

    // TODO: 4 - Create a static generic method: <T> List<T> filterNulls(List<T> list)
    //  It should return a new list containing only the non-null elements
    //  from the original list. Do not modify the original list.
    static <T> List<T> filterNulls(List<T> list){
        List<T> newList = new ArrayList<>();
        for (T item : list){
            if(item != null) {
                newList.add(item);
            }
        }

        return newList;
    }

    // TODO: 5 - Create a static generic method: <T> boolean contains(T[] array, T target)
    //  It should return true if the target is found in the array.
    //  Use the equals() method for comparison (handle null target).
    static <T> boolean contains(T[] array, T target){
        for (T item : array){
            if(target == null ? item == null : item.equals(target)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // TODO: 6 - Call all five methods above:
        //  (a) printArray with a String[] and an Integer[]
        //  (b) getFirst and getLast with a List<String> of names
        //  (c) filterNulls with a list that contains some null values
        //  (d) contains to search for an element in an array
        String[] names = {"oP", "Nelson", "Yusuf", "Ian", "Abas"};
        Integer[] scores = {25, 34, 78, 92,22};
        printArray(names);
        printArray(scores);
        System.out.println();

        List<String> names2 = List.of(
                "oP", "Nelson", "Yusuf", "Ian", "Abas"
        );
        System.out.println(names2.getFirst());
        System.out.println(names2.getLast());
        System.out.println();

        List<Integer> nums = new ArrayList<>();
        nums.add(90);
        nums.add(null);
        nums.add(17);
        nums.add(null);
        nums.add(null);
        nums.add(null);
        nums.add(89);
        nums.add(91);
        System.out.println(filterNulls(nums));
        System.out.println();

        System.out.println(contains(names, "oP"));


        // TODO: 7 - Demonstrate type inference: call printArray and contains
        //  WITHOUT explicitly specifying the type parameter (i.e., just call
        //  printArray(myArray) instead of GenericMethods.<String>printArray(myArray)).
        //  Add a comment explaining that the compiler infers T from the arguments.
        //  Compiler infers the data type of 'scores' from the argument
        printArray(scores);
        System.out.println(contains(names, "oP"));
    }
}
