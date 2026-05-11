package Chap9_Collection.priorityQueue;
import java.util.*;
import java.time.*;
/**
 * This program demonstrates the use of a priority queue
 * @version 1.0 2024-07-30
 * @author Neekon
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,12,10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));

        System.err.println("Iterating over elements ");
        for (LocalDate date : pq) 
        System.out.println(date);
        System.out.println("Removing elements");
        while(!pq.isEmpty())
         System.out.println(pq.remove());
    }
}
