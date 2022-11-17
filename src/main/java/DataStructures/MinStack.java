package DataStructures;

import java.util.Arrays;

public class MinStack {
    private int[] items;
    private int count;
    private int[] minItems;

    public MinStack(int capacity) {
        items = new int[capacity];
        minItems = new int[capacity];
        count = 0;
    }

    public void push(int i) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        if (stackEmpty() || minItems[count - 1] > i) {
            minItems[count] = i;
        } else {
            minItems[count] = minItems[count];
        }
        items[count++] = i;
    }

    public int pop() {
        if (stackEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];

    }

    public int peek() {
        if (stackEmpty()) {
            throw new IllegalStateException();
        }
        return items[count];
    }

    private boolean stackEmpty() {
        return count == 0;
    }

    public int getMin() {
        return minItems[count - 1];
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}