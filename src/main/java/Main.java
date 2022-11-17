import DataStructures.*;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var hashtable = new HashTable(100);
        hashtable.put(5, "Harry");
        hashtable.put(102, "Ron");
        System.out.println(hashtable.get(5));
        hashtable.remove(5);
        System.out.println(hashtable.get(5));
    }
}


