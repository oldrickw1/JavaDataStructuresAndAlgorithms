package DataStructures;

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
        newNode.next = null;

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
        //
    }

    public String print() {
        String strRep = "[";
        var pointer = first;
        if (pointer.next == null)
            return strRep += pointer.value + "]";
        while (pointer.next != null) {
            strRep += pointer.value + ",";
            pointer = pointer.next;
        }
        return strRep += pointer.value + "]";
    }

    public int getSize() {
        return size;
    }



}
