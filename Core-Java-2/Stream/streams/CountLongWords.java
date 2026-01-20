package Stream.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @version 1.0 2024-08-13
 * @author Neekon
 */

import java.util.*;

public class CountLongWords
{
    public static void main(String[] args) throws IOException {
        var contents = Files.readString(Paths.get("test.txt"));
        List<String> words = List.of(contents.split("\\PL+"));

        long count = 0;
        for(String w : words)
        {
            if (w.length() > 12) count++;
        }
        System.out.println(count);
        
        count = words.stream().filter(w->w.length()>12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w->w.length()>12).count();
        System.out.println(count);

    }
}