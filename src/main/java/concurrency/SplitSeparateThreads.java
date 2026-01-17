package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
You have work that can be split into separate threads and want to maximize available CPU resources.
@see <a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html">ThreadpoolExecutor</a> instance
 */
public class SplitSeparateThreads {
    public static void main (String [] args) throws InterruptedException {
        SplitSeparateThreads recipe = new SplitSeparateThreads();
        recipe.start();
    }


    private void start() throws InterruptedException {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        for (int i =0;i < 10;i++) {
            final int localI = i;
            queue.add((Runnable) () -> {
                doExpensiveOperation(localI);
            });
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,1000,
                TimeUnit.MILLISECONDS, queue);
        executor.prestartAllCoreThreads();
        executor.shutdown();
        executor.awaitTermination(100000,TimeUnit.SECONDS);

        System.out.println("All operations were completed");
    }

    private void doExpensiveOperation(int index) {
        System.out.println("Starting expensive operation "+index);
        try {
            Thread.sleep(index * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending   expensive operation " + index);
    }

}
