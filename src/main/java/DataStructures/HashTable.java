package DataStructures;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] entries;

    private class Entry {
        private int key;
        private String value;

        private Entry(int k, String v) {
            this.key = k;
            this.value = v;
        }
    }

    public HashTable(int capacity) {
        entries = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry != null)
            getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private Entry getEntry(int key) {
        var bucket= getBucket(key);
        if (bucket != null)
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        return null;
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();
        return entries[index];
    }

    public int hash(int i) {
        return i % entries.length;
    }
}
