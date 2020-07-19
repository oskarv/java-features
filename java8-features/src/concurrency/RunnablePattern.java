package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnablePattern {

    public static void main (String [] argv) {
        Runnable task = () -> System.out.println("thread code running ...  -- " + Thread.currentThread().getName());
        Thread thread = new Thread(task);
        thread.start();

        // Does the same as lines above
        new Thread(() -> System.out.println("What does this do? -- " + Thread.currentThread().getName())).start();

        // Executor doesn't create a new thread, it always reuses the same one
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // tasks are executed in the order of submission
        executor.execute(task);
        executor.execute(() -> System.out.println("new task -- " + Thread.currentThread().getName()));

        // Runnable can't return any results or throw errors, Callable is used when we need those two
        Callable<List<String>> callable = () -> Arrays.asList("**", "****", "*", "***");
        Future<List<String>> futureResult = executor.submit(callable);

        try {
            // get is a blocking call, it blocks until results are available!
            // we can pass time to get() method so we don't block the world forever in case something stuck
            System.out.println(futureResult.get() + " -- " + Thread.currentThread().getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}