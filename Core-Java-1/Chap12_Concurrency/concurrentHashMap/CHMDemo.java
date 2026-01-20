package Chap12_Concurrency.concurrentHashMap;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/**
 * This prgram demonstrates concurrent hash maps
 * @version 1.0 2024-08-07
 * @auther Neekon
 */
public class CHMDemo {
    public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    /**
     * Adds all words in the given file to the concurrent hash map
     * @param file a file
     * @throws IOException
     */
    public static void process(Path file) 
    {
        try (var in = new Scanner(file))
        {
            while (in.hasNext())
            {
                String word = in.next();
                map.merge(word, 1L, Long::sum);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Set<Path> descendants(Path rootDir) throws IOException
    {
        try (Stream<Path> entries = Files.walk(rootDir))
        {
            return entries.collect(Collectors.toSet());
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int processor = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processor);
        Path pathToRoot = Path.of(".");
        for (Path p : descendants(pathToRoot))
        {
            if(p.getFileName().toString().endsWith(".java"))
            executor.execute(()->{
                process(p);
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println(Thread.currentThread());
        map.forEach((k,v)->
       {
        if(v>=10)
        System.out.println(k+ " occurs " + v +" times");
       }); 
       
    }
}
