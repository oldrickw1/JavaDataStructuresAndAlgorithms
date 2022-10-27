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
        if (count == allocatedLength) {
            int[] newItems = new int[allocatedLength * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            newItems[count++] = item;
            items = newItems;
            allocatedLength *= 2;
            return;
        }
        items[count++] = item;
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
        String strRepr = "";
        strRepr += "[";
        if (count == 0)
            return strRepr + "]";
        for (int i = 0; i < count; i++)
            strRepr += items[i] + ", ";
        strRepr = strRepr.substring(0, strRepr.length() - 2);
        strRepr += "]";

        return strRepr;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }
}
