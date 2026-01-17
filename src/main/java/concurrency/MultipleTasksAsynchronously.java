package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
Your application requires multiple tasks to be performed simultaneously in an
asynchronous manner, such that none of the tasks block one another.
@see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletableFuture.html">CompletableFuture<T> </a>

 */
public class MultipleTasksAsynchronously {

    public static void main(String[] args) {
        try {
            CompletableFuture tasks = performWork()
                    .thenApply(work -> {
                        String newTask = work + " Second task complete!";
                        System.out.println(newTask);
                        return newTask;
                    }).thenApply(finalTask -> finalTask + " Final Task Complete!");

            CompletableFuture future = performSecondWork("Java 9 is Great! ");
            while(!tasks.isDone()){
                System.out.println(future.get());
            }
            System.out.println(tasks.get());


        } catch (ExecutionException | InterruptedException ex) {
            System.out.println("ExecutionException | InterruptedException " +  ex);
        }
    }

    /**
     *
     * @return CompleableFuture object
     */
    public static CompletableFuture performWork() {
        CompletableFuture resultingWork = CompletableFuture.supplyAsync(
                () -> {
                    String taskMessage = "First task complete!";
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                    System.out.println(taskMessage);
                    return taskMessage;
                });
        return resultingWork;

    }

    /**
     * Accepts a String and returns a CompletableFuture.
     * @param message
     * @return CompletableFuture
     */
    public static CompletableFuture performSecondWork(String message) {
        CompletableFuture resultingWork = CompletableFuture.supplyAsync(
                () -> {
                    String taskMessage = message + " Another task complete!";
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }

                    return taskMessage;
                });
        return resultingWork;

    }
}
