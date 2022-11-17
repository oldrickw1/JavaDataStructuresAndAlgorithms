package DataStructures;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] arr;

    private class Entry {
        private int key;
        private String value;

        private Entry(int k, String v) {
            this.key = k;
            this.value = v;
        }
    }

    public HashTable(int capacity) {
        arr = new LinkedList[capacity];
    }

    public void put(int k, String v) {
        int index = hash(k);
        if (arr[index] == null) {
            arr[index] = new LinkedList<Entry>();
            arr[index].add(new Entry(k, v));
        }
        else {
            var iterator = arr[index].iterator();
            while (iterator.hasNext()) {
                var entry = iterator.next();
                if (entry.key == k)
                    entry.value = v;
            }
        }
    }


    public String get(int k) {
        var ll = arr[hash(k)];
        var iterator = ll.iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.key == k)
                return entry.value;
        }
        return "NO SUCH KEY";
    }

    public void remove(int k) {
        var ll = arr[hash(k)];
        var iterator = ll.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.key == k) {
                break;
            }
            counter++;
        }
        ll.remove(counter);
    }

    public int hash(int i) {
        return i % 100;
    }
}
