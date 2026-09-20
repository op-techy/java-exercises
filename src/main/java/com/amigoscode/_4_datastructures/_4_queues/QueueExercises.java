package com.amigoscode._4_datastructures._4_queues;

// Exercise: Queue Operations
// Learn how to use Queue and PriorityQueue - First In, First Out (FIFO) and priority-based ordering.

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExercises {

    public static void main(String[] args) {

        // --- Basic Queue Operations ---
        System.out.println("--- Basic Queue (LinkedList) ---");

        Queue<String> queue = new LinkedList<>();

        queue.offer("Task1");
        queue.offer("Task2");
        queue.offer("Task3");
        queue.offer("Task4");
        queue.offer("Task5");

        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue);

        for (String s : queue){
            System.out.println(s);
        }


        // --- PriorityQueue ---
        System.out.println("\n--- PriorityQueue ---");

        PriorityQueue<Integer>  integers = new PriorityQueue<>();
        integers.add(50);
        integers.add(20);
        integers.add(40);
        integers.add(10);
        integers.add(30);

        System.out.println(integers);


        // --- Print Queue Simulation ---
        System.out.println("\n--- Print Queue Simulation ---");

        // TODO: 7 - Simulate a print queue: create a Queue of Strings representing print jobs
        //           Add these jobs using offer(): "Report.pdf", "Photo.jpg", "Letter.docx", "Slides.pptx"
        //           Process (poll) each job one by one, printing "Printing: <job>" for each
        //           Continue until the queue is empty
        Queue<String> jobs = new LinkedList<>();
        jobs.offer("Report.pdf");
        jobs.offer("Photo.jpg");
        jobs.offer("Letter.docx");
        jobs.offer("Slides.pptx");

        printJob(jobs);
    }

    static void printJob(Queue<String> queue){
        while (!queue.isEmpty()){
                String s = queue.poll();
                System.out.printf("Printing: %s\n",s);

        }
    }
}
