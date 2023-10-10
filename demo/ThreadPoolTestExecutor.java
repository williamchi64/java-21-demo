package demo;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadPoolTestExecutor {
    public void execute(int nThreads) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Callable<String>> callableList = IntStream.range(0, 100000).mapToObj(i -> (Callable<String>) new TestCallable(i)).toList();
        try {
            List<Future<String>> results = executorService.invokeAll(callableList);
            boolean isSuccess = results.stream().map(result -> {
                try {
                    return result.get();
                } catch (InterruptedException | ExecutionException e) {
                    return "Failed";
                }
            }).allMatch("Success"::equals);
            if (isSuccess) {
                long end = System.currentTimeMillis();
                System.out.println("The execution spent: " + (end - start));
            } else {
                System.out.println("Something wrong");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
