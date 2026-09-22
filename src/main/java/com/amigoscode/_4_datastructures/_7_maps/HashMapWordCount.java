package com.amigoscode._4_datastructures._7_maps;

// Exercise: Word Frequency Counter using HashMap
// A practical exercise to count word occurrences in a sentence.

import java.util.*;

public class HashMapWordCount {

    public static void main(String[] args) {

        String sentence = "the cat sat on the mat and the cat ate the rat on the mat";

        // TODO: 1 - Split the sentence into an array of words using split(" ")
        String[] words = sentence.split(" ");


        // TODO: 2 - Create a HashMap<String, Integer> called 'wordCount'
        //           Iterate through the words array and count the frequency of each word
        //           Hint: use getOrDefault(word, 0) + 1 to increment the count
        HashMap<String,Integer> wordCount = new HashMap<>();
        for (String word : words){
            wordCount.put(word,wordCount.getOrDefault(word, 0) + 1);
        }


        // TODO: 3 - Print each word and its count by iterating over the map
        //           Format: "<word>: <count>"
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        // TODO: 4 - Find and print the most frequent word
        //           Iterate through the entrySet and track the entry with the highest value
        int maxCount = 0;
        String mostFrequent = "";
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        System.out.printf("The most frequent word is '%s' \n\n", mostFrequent);

        // TODO: 5 - Find and print all words that appear only once
        //           Iterate through the entrySet and collect entries where value == 1
        int minCount = 1;
        String leastFrequent = "";
        System.out.println("These words only appear once: ");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()){
            if (entry.getValue() == minCount){
                leastFrequent = entry.getKey();
                System.out.println(leastFrequent);
            }
        }
        System.out.println();

        // TODO: 6 - Sort the map entries by value (frequency) in descending order and print
        //           Hint: create a List from entrySet(), then sort using a Comparator
        //           that compares entry values in reverse order
      List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
      entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
      System.out.println(entries);

    }
}
