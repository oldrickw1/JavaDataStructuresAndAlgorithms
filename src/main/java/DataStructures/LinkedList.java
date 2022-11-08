package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList {

    private int size = 0;
    private Node first, last;

    private class Node {
        private int value;
        private Node next;
    }

    public void addFirst(int value) {
        var newNode = new Node();
        newNode.value = value;

        if (first == null)
            first = last = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        var pointer = first;
        for (int i = 0; i <= index; i++) {
            if (i == index)
                return pointer.value;
            pointer = pointer.next;
        }
        return -1;
    }

    public String print() {
        String strRep = "[";
        if (first == null)
            return strRep + "]";
        var pointer = first;
        if (pointer.next == null)
            return strRep + pointer.value + "]";
        while (pointer.next != null) {
            strRep += pointer.value + ",";
            pointer = pointer.next;
        }
        return strRep + (pointer.value + "]");
    }

    public int getSize() {
        return size;
    }

    public void addLast(int value) {
        var node = new Node();
        node.value = value;

        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int deleteFirst() {
        if (first == null)
            throw new NoSuchElementException("LinkedList is empty");
        int removedItem = first.value;
        if (first.next == null)
            first = last = null;
        else
            first = first.next;
        size--;
        return removedItem;
    }

    public int deleteLast() {
        if (last == null)
            throw new NoSuchElementException("LinkedList isEmpty");

        int removedItem = last.value;
        size--;

        if (first.next == null) {
            first = last = null;
            return removedItem;
        }
        Node tmp = first;
        while (true) {
            if (tmp.next.next == null) {
                last = tmp;
                last.next = null;
                return removedItem;
            }
            tmp = tmp.next;
        }
    }

    public boolean contains(int item) {
        if (first != null) {
            Node tmp = first;
            while (tmp.next != null) {
                if (tmp.value == item)
                    return true;
                tmp = tmp.next;
            }
            if (tmp.value == item)
                return true;
        }
        return false;
    }
}
