package Stream.parallel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParallelStreams {
    public static void main(String[] args) throws IOException {
        var contents = new String(Files.readAllBytes(Paths.get("test.txt")),StandardCharsets.UTF_8);
        List<String> wordList = List.of(contents.split("\\PL+"));
        
        //very bad code ahead
        var shortWords = new int[10];
        wordList.parallelStream().forEach(s->
        {
            if(s.length()<10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        //Try again-the result will be different (also wrong)
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s -> 
        {
        if (s.length() < 10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        //Remedy: Group and count
        Map<Integer, Long> shortWordCounts = wordList.parallelStream().
        filter(s->s.length()<10).
        collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println(shortWordCounts);

        //Downstream order not deterministic
        Map<Integer,List<String>> result = wordList.parallelStream().collect(
            Collectors.groupingBy(String::length));
        System.out.println(result.get(14));

        result = wordList.parallelStream().collect(
            Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
            Collectors.groupingByConcurrent(String::length, Collectors.counting()));
        System.out.println(wordCounts);

    }
}
