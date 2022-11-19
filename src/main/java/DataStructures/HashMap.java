package DataStructures;

public class HashMap {
    private Entry[] entries;
    private int size = 0;
    private final int capacity;

    public HashMap(int capacity) {
        entries = new Entry[capacity];
        this.capacity = capacity;
    }

    private class Entry {
        private int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, String value) {
        try {
            MakeEntryRecursively(new Entry(key, value), hash(key));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void MakeEntryRecursively(Entry entry, int index) throws Exception {
        if (size == capacity) {
            throw new Exception("Map is full");
        }
        if (entries[index] == null) {
            size++;
            entries[index] = entry;
        } else MakeEntryRecursively(entry, (index + 1) % capacity);
    }

    public String get(int key) {
        try {
            return getEntryRecursively(key, hash(key), 0).value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    private Entry getEntryRecursively(int key, int index, int count) throws Exception {
        if (count == capacity) {
            throw new Exception("No such key");
        }
        var entry = entries[index];
        if (entry == null || entry.key != key) {
            return getEntryRecursively(key, index + 1, count + 1);
        }
        return entry;
    }

    public void remove(int key) {

    }

    public int size() {
        return size;
    }

    private int hash(int key) {
        return key % capacity;
    }
}
