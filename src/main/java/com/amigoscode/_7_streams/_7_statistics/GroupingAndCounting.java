package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Grouping and Counting
 *
 * Practice advanced grouping scenarios including finding the most common
 * element, partitioning, and using downstream collectors like mapping() and maxBy().
 */
public class GroupingAndCounting {

    record Student(String name, int grade, String subject) {}

    public static void main(String[] args) {
        List<String> wordsWithRepeats = List.of(
                "java", "streams", "lambda", "java", "streams",
                "java", "functional", "lambda", "streams", "api",
                "java", "lambda", "functional", "api", "streams"
        );

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        List<Student> students = List.of(
                new Student("Alice", 92, "Math"),
                new Student("Bob", 85, "Science"),
                new Student("Charlie", 78, "Math"),
                new Student("Diana", 95, "Science"),
                new Student("Eve", 88, "Math"),
                new Student("Frank", 72, "Science"),
                new Student("Grace", 91, "Math"),
                new Student("Henry", 83, "Science")
        );

        // TODO: 1 - Group 'wordsWithRepeats' by the word itself and count occurrences
        //           Result type: Map<String, Long>
        //           Print each word and its count
        Map<String, Long> countByWords = wordsWithRepeats.stream()
                .collect(Collectors.groupingBy(w -> w , Collectors.counting()));
        countByWords.forEach((word, count) -> IO.println(word + ": " + count));
        IO.println();

        // TODO: 2 - Find the most common word in 'wordsWithRepeats'
        //           Group by word, count occurrences, then find the entry with max value
        //           Hint: Use entrySet().stream() on the grouped map, then max()
        //           Print the word and its count
        countByWords.entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(w -> IO.println(w.getKey() + ": " + w.getValue()));
        IO.println();

        // TODO: 3 - Use Collectors.partitioningBy to split 'numbers' into even and odd
        //           Result type: Map<Boolean, List<Integer>>
        //           Print the even numbers (key=true) and odd numbers (key=false)
        Map<Boolean, List<Integer>> oddEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        IO.println("Even: " + oddEven.get(true));
        IO.println("Odd: " + oddEven.get(false));
        IO.println();

        // TODO: 4 - Partition 'students' into those with grade >= 85 (pass) and below (fail)
        //           Print each group
        Map<Boolean, List<Student>> byGrade = students.stream()
                .collect(Collectors.partitioningBy(s -> s.grade() >= 85));
        IO.println("85 or Higher: " + byGrade.get(true));
        IO.println("Below 85: " + byGrade.get(false));
        IO.println();

        // TODO: 5 - Use Collectors.mapping() within groupingBy:
        //           Group students by subject, but collect only their names (not full objects)
        //           Hint: Collectors.groupingBy(Student::subject, Collectors.mapping(Student::name, Collectors.toList()))
        //           Print each subject and its list of student names
        Map<String, List<String>> groupingBy = students.stream()
                .collect(Collectors.groupingBy(Student::subject, Collectors.mapping(Student::name, Collectors.toList())));
        IO.println(groupingBy);
        IO.println();

        // TODO: 6 - Use maxBy as a downstream collector:
        //           Group students by subject and find the highest-scoring student per subject
        //           Use Collectors.groupingBy with Collectors.maxBy
        //           Print each subject and its top student
        Map<String, Optional<Student>> highestPerSubject = students.stream()
                .collect(Collectors.groupingBy(Student::subject, Collectors.maxBy(Comparator.comparingInt(Student::grade))));
        highestPerSubject.forEach((subject, student) -> IO.println(subject + ": " + student));
    }
}
