package demo;

public class App {
    public static void main(String[] args) {
        new ThreadExecutor().execute(Thread.ofVirtual());
//        new ThreadExecutor().execute(Thread.ofPlatform());
//        new ThreadPoolTestExecutor().execute(30000);
    }
}
