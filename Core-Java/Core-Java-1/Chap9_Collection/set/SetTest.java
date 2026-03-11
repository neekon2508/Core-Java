package Chap9_Collection.set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This program uses a set to print all unique words in System.in
 * @version 1.0 2024-07-30
 * @author Neekon
 */
public class SetTest {
    public static void main(String[] args) throws FileNotFoundException {
        var words = new HashSet<String>();
        long totalTime = 0;

        try (var in = new Scanner(new File("Chap9_Collection\\set\\alice30.txt")))
        {
            while(in.hasNext())
            {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i =1; i<=20 && iter.hasNext(); i++)
         System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words." + totalTime + " milliseconds");
    }
}
