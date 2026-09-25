package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.*;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    record Student(String name, int grade, String subject) {}

    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 92, "Math"));
        students.add(new Student("Brian", 85, "English"));
        students.add(new Student("Chinedu", 78, "Physics"));
        students.add(new Student("Diana", 94, "Biology"));
        students.add(new Student("Emeka", 88, "Math"));
        students.add(new Student("Fatima", 76, "English"));
        students.add(new Student("Grace", 91, "Physics"));
        students.add(new Student("Henry", 83, "Biology"));
        students.add(new Student("Ibrahim", 89, "Math"));
        students.add(new Student("Jessica", 95, "English"));


        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> bySubject = new HashMap<>();

        for (Student s : students){
            bySubject.computeIfAbsent(s.subject, k -> new ArrayList<>()).add(s);
        }

        for (Map.Entry<String, List<Student>> e : bySubject.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());
        }
        System.out.println();


        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> subjects = new HashSet<>();

        for (Student s : students){
            subjects.add(s.subject);
        }

        System.out.println(subjects);
        System.out.println();

        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Stack<Student> lastViewed = new Stack<>();
        lastViewed.push(students.get(3));
        lastViewed.push(students.get(6));
        lastViewed.push(students.get(9));
        while (!lastViewed.isEmpty()){
            System.out.println(lastViewed.pop());
        }
        System.out.println();

        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list
        students.sort(Comparator.comparingInt(Student::grade).reversed());
        for (Student s : students){
            System.out.println(s);
        }
        System.out.println();

        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("Total students: " + students.size());
        System.out.println("Unique subjects: " + subjects.size());
        System.out.println("Highest grade: " + students.getFirst());
        for (Map.Entry<String, List<Student>> entry: bySubject.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " students");
        }

    }
}
