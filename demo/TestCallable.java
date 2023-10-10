package demo;

import java.util.concurrent.Callable;

public class TestCallable implements Callable<String> {
    private int i;

    public TestCallable(int i) {
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        new TestRunnable(i).run();
        return "Success";
    }
}
