package Chap12_Concurrency.executors;
import java.util.concurrent.*;
import java.util.*;
public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        var executor = Executors.newFixedThreadPool(8);
        var service = new ExecutorCompletionService<Integer>(executor);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for(int i =1;i<=100;++i)
        {
            int a =i;
            Callable<Integer> t = () -> a*10;
            tasks.add(t);
        }
        
       for (var task : tasks) service.submit(task);
       for(int i =0;i<tasks.size();++i)
       System.out.println(service.take().get());
    }
}
