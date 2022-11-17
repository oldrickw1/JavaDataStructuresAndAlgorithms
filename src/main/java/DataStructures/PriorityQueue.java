package DataStructures;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
        count = 0;
    }

    public void push(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        if (isEmpty()) {
            items[count++] = item;
        }

        else {
            for (int i = count; i > 0 ; i--) {
                if (items[i - 1] > item) {
                    items[i] = items[i - 1];
                } else {
                    items[i] = item;
                    break;
                }
                if (i == 1) {
                    items[i - 1] = item;
                }
            }
            count++;
        }

    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == items.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, count));
    }
}
