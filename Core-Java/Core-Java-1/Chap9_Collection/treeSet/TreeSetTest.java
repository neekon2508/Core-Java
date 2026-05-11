package Chap9_Collection.treeSet;
import java.util.*;
/**
 * This program demonstrates a set of Item objects by comparing their descriptions
 * @version 1.0 2024-07-30
 * @author Neekon
 */
public class TreeSetTest {
    public static void main(String[] args) {
        var parts = new TreeSet<Item>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);
        // var sortByDescription = new TreeSet<Item>((first,second)->(first.getDescription().compareTo(second.getDescription())));
        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.err.println(sortByDescription);
    }
}
