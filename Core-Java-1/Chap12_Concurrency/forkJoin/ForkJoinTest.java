package Chap12_Concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * This program demonstrates the fork-join framework
 * @version 1.0 2024-08-08
 * @author Neekon
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE = 1000000;
        var numbers = new double[SIZE];
        for (int i =0;i<SIZE;i++) numbers[i] = Math.random();
        var counter = new Counter(numbers, 0, numbers.length, x->x>0.5);
        var pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}
