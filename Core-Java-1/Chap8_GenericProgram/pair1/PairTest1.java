package Chap8_GenericProgram.pair1;

import java.util.Collection;

/**
 * @version 1.0 2024-07-12
 * @author Neekon
 */
public class PairTest1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // String[] words = {"Mary", "had", "a", "little", "lamb"};
        // Pair<String> mm = ArrayAlg.minmax(words);
        // System.out.println("min= "+mm.getFirst());
        // System.err.println("max= "+mm.getSecond());
        Pair<String> p = Pair.makePair(()-> new String());
        // Pair<String> p = Pair.makePair(String.class);
        Pair<String> pair1 = new Pair<String>("Nghia","Giang");
        Pair<String> pair2 = new Pair<String>("Minh","Ha");
        Pair<String>[] table = Pair.array(pair1,pair2);
        for(var t : table)
        System.out.println(t.getFirst()+" "+t.getSecond());

    }
    
}
/**
 * Gets the minimum and maximum of an array of strings
 * @param a an array of strings
 * @return a pair with the min and max values, or null if a is null or empty
 */
class ArrayAlg
{
    public static Pair<String> minmax(String[] a)
    {
        if (a==null || a.length==0) return null;
        String min = a[0];
        String max = a[0];
        for(int i =1;i< a.length;i++)
        {
            if(min.compareTo(a[i])>0) min = a[i];
            if(max.compareTo(a[i])<0) max = a[i];
        }
        return new Pair<>(min,max);
    }
   
}