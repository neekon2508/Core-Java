package Chap9_Collection.treeSet;
import java.util.*;
/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;
    
    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }
    
    @Override
    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }

    @Override
    public int hashCode() {
       return Objects.hash(description, partNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        var other = (Item) obj;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Item other) {
       int diff = Integer.compare(partNumber, other.partNumber);
       return diff != 0 ? diff : description.compareTo(other.description);
    }
    
}
