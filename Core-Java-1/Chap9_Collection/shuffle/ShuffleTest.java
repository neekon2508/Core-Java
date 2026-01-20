package Chap9_Collection.shuffle;
import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms
 * @version 1.0 2024-08-03
 * @author Neekon
 */
public class ShuffleTest {
    public static void main(String[] args) {
        var num = new LinkedList<Integer>();
        for(int i =1;i<=30;++i) num.add(i);
        System.out.println(num);
        System.out.println(Collections.binarySearch(num, 2));
        System.out.println(Collections.max(num,(a,b)->-a+b));
    }
}
