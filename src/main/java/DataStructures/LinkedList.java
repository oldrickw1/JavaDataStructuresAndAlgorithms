package DataStructures;

import java.util.NoSuchElementException;

public class LinkedList {

    private int size = 0;
    private Node first, last;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int value) {
        var newNode = new Node(value);

        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }
        int removedItem = first.value;

        if (listHasOneItem()) {
            clearList();
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
        return removedItem;
    }

    public int deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList isEmpty");
        }
        int removedItem = last.value;

        if (listHasOneItem()) {
            clearList();
        } else {
            var previous = getPrevious(last);
            last = previous;
            previous.next = null;
        }

        size--;
        return removedItem;
    }

    public int getSize() {
        /** returns the size of the Linked List */
        return size;
    }

    @Override
    public String toString() {
        StringBuilder strRep = new StringBuilder("[");
        if (isEmpty()) {
            return strRep + "]";
        }
        var pointer = first;
        if (pointer.next == null) {
            return strRep.toString() + pointer.value + "]";
        }
        while (pointer.next != null) {
            strRep.append(pointer.value).append(",");
            pointer = pointer.next;
        }
        return strRep + (pointer.value + "]");
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        var pointer = first;
        for (int i = 0; i <= index; i++) {
            if (i == index)
                return pointer.value;
            pointer = pointer.next;
        }
        return -1;
    }

    private void clearList() {
        first = last = null;
    }

    private boolean listHasOneItem() {
        return first.next == null;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
