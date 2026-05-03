package Concurrency.Test.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class SynchronizedInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}

public class App {

    public static void main(String[] args) {
        SynchronizedInteger syncInt = new SynchronizedInteger();
        ExecutorService executor = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            final int val = i;
            executor.execute(() -> syncInt.set(val));
            executor.execute(() -> {
                int current = syncInt.get();
                if (val != current)
                    System.out.println("FALSE");
            });
        }
        executor.shutdown();
        System.out.println("Test complete");
    }
}
