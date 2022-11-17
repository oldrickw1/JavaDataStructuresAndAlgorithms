package DataStructures;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int first;
    private int last;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        first = last = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
//        if (last == items.length) {
////            rearrangeToFront();
//        }
        items[last] = item;
        last = (last + 1) % items.length;
    }

//    private void rearrangeToFront() {
//        for (int i = first; i < last; i++) {
//            items[i - first] = items[i];
//        }
//        last -= first;
//        first = 0;
//    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int fItem = items[first];
        first = first + 1 % items.length;
        return fItem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[first];
    }

    public boolean isEmpty() {
        return first == last;
    }

    public boolean isFull() {
        return (last - first == items.length);
    }

    public String print() {
        return Arrays.toString(items);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
