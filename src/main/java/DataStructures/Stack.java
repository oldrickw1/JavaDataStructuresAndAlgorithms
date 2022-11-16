package DataStructures;

import java.util.Arrays;

public class Stack {
    private int count;
    private int[] items;

    public Stack(int capacity) {
        items = new int[capacity];
        this.count = 0;
    }

    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        items[count++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var arr = new int[count];
        System.arraycopy(items, 0, arr, 0, count);
        return Arrays.toString(arr);
    }
}
