package DataStructures;

import javax.swing.plaf.IconUIResource;
import java.util.NoSuchElementException;

public class LinkedList {

    private int size = 0;
    private Node first, last;

    protected class Node {
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

    public int[] toArray() {
        int[] arr = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    /** returns the size of the linked list */
    public int getSize() {
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
        while (current != null || current != node) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }

        var current = first.next;
        var previous = first;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first.next = null;
        last = first;
        first = previous;
    }

    public int kthFromLast(int k) throws Exception {
        int index = size - k;
        return get(index);
    }

    public void printMiddle() {
        if (first == null)
            throw new IllegalStateException("List is empty");

        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }
        System.out.println(b == last ? a.value : a.value + ", " + b.value);
    }

    public boolean hasLoop() {
        if (first == null || first.next == null)
            return false;
        var a = first;
        var b = first.next;

        while (b != null && b.next != null) {
            if (a == b)
                return true;
            b = b.next.next;
            a = a.next;
        }
        return false;
    }

    public void createWithLoop() {
        last.next = first;
    }
}
