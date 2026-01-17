package concurrency.flow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class DemoExample {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Flow_submissionPublisher();
    }


    private static void Flow_submissionPublisher() {
        System.out.println();

        ExecutorService execService =  ForkJoinPool.commonPool();//Executors.newFixedThreadPool(3);
        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()){//execService, 1)){
            demoSubscribe(publisher, execService, "One");
            demoSubscribe(publisher, execService, "Two");
            demoSubscribe(publisher, execService, "Three");
            IntStream.range(1, 5).forEach(publisher::submit);
        } finally {
            try {
                execService.shutdown();
                int shutdownDelaySec = 1;
                System.out.println("Waiting for " + shutdownDelaySec + " sec before shutting down service...");
                execService.awaitTermination(shutdownDelaySec, TimeUnit.SECONDS);
            } catch (Exception ex) {
                System.out.println("Caught around execService.awaitTermination(): " + ex.getClass().getName());
            } finally {
                System.out.println("Calling execService.shutdownNow()...");
                List<Runnable> l = execService.shutdownNow();
                System.out.println(l.size() + " tasks were waiting to be executed. Service stopped.");
            }

        }

    }

    private static void demoSubscribe(SubmissionPublisher<Integer> publisher,
                       ExecutorService execService, String subscriberName){
        DemoSubscriber<Integer> subscriber =
                new DemoSubscriber<>(subscriberName);
        DemoSubscription subscription =
                new DemoSubscription(subscriber, execService);
        subscriber.onSubscribe(subscription);
        publisher.subscribe(subscriber);
    }
}
