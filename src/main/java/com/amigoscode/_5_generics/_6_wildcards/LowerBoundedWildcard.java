package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Lower Bounded Wildcards (? super T)
 *
 * A lower bounded wildcard <? super Integer> accepts Integer and all its
 * supertypes (Number, Object). This is useful when you want to WRITE to
 * a generic structure.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list CONSUMES values (you write to it), use "super".
 *
 * Complete the TODOs below.
 */
public class LowerBoundedWildcard {

    // TODO: 1 - Create a static method: void addNumbers(List<? super Integer> list)
    //  It should add the integers 1, 2, and 3 to the list.
    //  This works because any list that holds Integer or a supertype of Integer
    //  can safely accept Integer values.
    static void addNumbers(List<? super Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
    }


    // TODO: 2 - Create a static method:
    //  <T> void moveElements(List<? extends T> source, List<? super T> destination)
    //  It should read each element from source and add it to destination.
    //  This is the PECS principle in action:
    //    source uses "extends" because it PRODUCES elements (we read from it)
    //    destination uses "super" because it CONSUMES elements (we write to it)
    static <T> void moveElements(List<? extends T> source, List<? super T> destination){
        for (T element : source){
            destination.add(element);
        }
    }


    public static void main(String[] args) {

        // TODO: 3 - Call addNumbers() with three different list types:
        //  (a) List<Integer>   - Integer is Integer (exact match)
        //  (b) List<Number>    - Number is a supertype of Integer
        //  (c) List<Object>    - Object is a supertype of Integer
        //  Print each list after calling addNumbers().
        List<Integer> intList = new ArrayList<>();
        addNumbers(intList);
        IO.println(intList);
        IO.println();

        List<Number> numList = new ArrayList<>();
        addNumbers(numList);
        IO.println(numList);
        IO.println();

        List<Object> objList = new ArrayList<>();
        addNumbers(objList);
        IO.println(objList);
        IO.println();


        // TODO: 4 - Demonstrate that you CAN add Integer to List<? super Integer>.
        //  Create a List<? super Integer> variable, assign a new ArrayList<Number>()
        //  to it, and add several Integer values. Print the list.
        //  Then try adding a Double and observe/explain the compile error (commented out).
        List<? super Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        IO.println(list);
        IO.println();
        // list.add(3.14);  // Why doesn't this compile even though list holds Numbers?
        IO.println("The value '3.14' can't be added to the list as it's a double and the list only accepts " +
                "Integer -> Number -> Object");
        IO.println();


        // TODO: 5 - Use moveElements() to move elements from a List<Integer> source
        //  to a List<Number> destination. Print the destination list to verify.
        List<Number> intCopy = new ArrayList<>();
        moveElements(intList, intCopy);
        IO.println(intCopy);
        IO.println();


        // TODO: 6 - Add a comment below explaining the PECS principle
        //  (Producer Extends, Consumer Super) as it applies to this exercise.
        //  Why is "super" appropriate when the list is a CONSUMER (we write to it)?
        //  How does this complement the "extends" wildcard?
        // PECS: Producer Extends, Consumer Super.
        // "Super" is appropriate because this list is a CONSUMER: we write values
        // into it. A List<Number>, List<Object>, etc. can safely accept an Integer.
        // This complements "extends": extends is used when we READ from a generic
        // structure, while super is used when we WRITE to one.
    }
}
