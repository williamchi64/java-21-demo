package demo;

import java.util.List;
import java.util.stream.IntStream;

public class ThreadExecutor {
    public void execute(Thread.Builder builder) {
        long start = System.currentTimeMillis();
        List<Thread> threads = IntStream.range(0, 100000).mapToObj(i -> builder.unstarted(new TestRunnable(i))).toList();
        threads.forEach(Thread::start);
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long end = System.currentTimeMillis();
        System.out.println("The execution spent: " + (end - start));
    }
}
