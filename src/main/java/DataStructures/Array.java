package DataStructures;

public class Array {
    private int allocatedLength;
    public int[] items;
    public int count;

    public Array(int allocatedLength) {
        this.allocatedLength = allocatedLength;
        items = new int[allocatedLength];
        count = 0;
    }

    public void insert(int item) {

    }

    public int removeAt(int index) {
        if (index >= count || index < 0)
            throw new IndexOutOfBoundsException("Not a valid index for this array");

        int removedItem = items[index];
        count--;
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        return removedItem;
    }

    public String print() {
        return "Todo";
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }
}
