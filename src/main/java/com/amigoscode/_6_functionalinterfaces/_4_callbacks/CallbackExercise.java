package com.amigoscode._6_functionalinterfaces._4_callbacks;

import java.lang.classfile.attribute.SourceFileAttribute;
import java.util.function.Consumer;

/**
 * Exercise: Callbacks with Functional Interfaces
 *
 * Callbacks are functions passed as arguments to other functions, to be called
 * at a later time (e.g., on success or failure). In Java, functional interfaces
 * like Consumer and Runnable make excellent callback types.
 *
 * This exercise simulates asynchronous-style programming patterns using
 * callbacks for success/failure handling and task completion notification.
 */
public class CallbackExercise {

    public static void main(String[] args) {

        // TODO: 4 - Call fetchData with two lambda callbacks:
        //  - onSuccess: prints "Data received: <data>"
        //  - onFailure: prints "Error occurred: <error>"
        //  Call fetchData twice:
        //    a) with simulateSuccess = true
        //    b) with simulateSuccess = false
        fetchData(true, data -> System.out.printf("Data received: %s \n", data), error -> System.out.printf("Error occurred: %s \n", error));
        fetchData(false, data -> System.out.printf("Data received: %s \n", data), error -> System.out.printf("Error occurred: %s \n", error));

        // TODO: 5 - Call processAsync with:
        //  - task: a Runnable that prints "Processing data..."
        //  - onComplete: a Runnable that prints "Processing complete!"
        processAsync(() -> IO.println("Processing data..."), () -> IO.println("Processing complete!"));
        IO.println();

        // TODO: 6 - Use callbacks to chain operations. Call performSteps below
        //  with three Runnable callbacks: step1 prints "Step 1: Loading",
        //  step2 prints "Step 2: Transforming", step3 prints "Step 3: Saving".
        //  The method will execute them in order.
        performSteps(
                () -> System.out.println("Step 1: Loading"),
                () -> System.out.println("Step 2: Transforming"),
                () -> System.out.println("Step 3: Saving")
        );
    }

    // TODO: 1 - Create a method called fetchData that takes:
    //    boolean simulateSuccess,
    //    Consumer<String> onSuccess,
    //    Consumer<String> onFailure
    //  If simulateSuccess is true, call onSuccess with "{ \"id\": 1, \"name\": \"Alice\" }"
    //  If simulateSuccess is false, call onFailure with "Connection timed out"
    static void fetchData(boolean simulateSuccess,
                          Consumer<String> onSuccess,
                          Consumer<String> onFailure){

        IO.println("Fetching data...");

        if (simulateSuccess){
            onSuccess.accept("{ \"id\": 1, \"name\": \"Alice\" } \n");
        } else {
            onFailure.accept("Connection timed out \n");
        }
    }


    // TODO: 2 - Inside fetchData (from TODO 1), before calling the callbacks,
    //  print "Fetching data..." to simulate work being done.


    // TODO: 3 - Create a method called processAsync that takes:
    //    Runnable task,
    //    Runnable onComplete
    //  It should run the task first, then call onComplete.
    //  Print "Starting process..." before the task and "Done." after onComplete.
    static void processAsync(Runnable task, Runnable onComplete){
        IO.println("Starting process...");
        task.run();
        onComplete.run();
        IO.println("Done.");
    }


    /**
     * Executes three steps in sequence using Runnable callbacks.
     */
    static void performSteps(Runnable step1, Runnable step2, Runnable step3) {
        System.out.println("=== Beginning multi-step operation ===");
        step1.run();
        step2.run();
        step3.run();
        System.out.println("=== All steps completed ===");
    }
}
