package Chap9_Collection.map;
import java.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class CountWord {
public static void main(String[] args) throws IOException {
    var counts = new HashMap<String, Integer>();
    String filePath = "";
    try (Scanner in = new Scanner(System.in))
    {
        while(filePath.isEmpty())
         {
            System.out.println("Nhap duong dan tuong doi cua text file: ");
            filePath = in.nextLine();
         }
    }
    try(Scanner in = new Scanner(Path.of(filePath),StandardCharsets.UTF_8))
    {
        while(in.hasNext())
        {
            String word = in.next();
            var s = new String[] {".",",",";",":"};
            for(var w : s)
                while(word.contains(w))
                word = word.replace(w,"");
            counts.merge(word,1,Integer::sum);
        }
        if(counts.size()!=0)
        {
            counts.forEach((k,v)->System.out.println(k+" = "+v));
        }
        else System.out.println("No words in the file");
    }
}
}
