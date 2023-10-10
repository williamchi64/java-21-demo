package demo;

import java.time.Duration;

public class TestRunnable implements Runnable {
    private int i;

    public TestRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread() + " Thread start " + i);
            System.out.println(Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(10L));
            System.out.println(Thread.currentThread() + " Thread end " + i);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
