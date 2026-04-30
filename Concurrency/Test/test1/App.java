package Concurrency.Test.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(executor);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int a = i;
            Callable<Integer> t = () -> a * 10;
            tasks.add(t);
        }
        for (Callable<Integer> task : tasks)
            service.submit(task);
        for (int i = 0; i < tasks.size(); i++)
            System.out.println(service.take().get());
    }
}
