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
            doubleMemoAllocation();
        }
        items[count++] = item;
    }

    private void doubleMemoAllocation() {
        int[] newItems = new int[(allocatedLength == 0) ? 2 : allocatedLength * 2];
        for (int i = 0; i < count; i++)
            newItems[i] = items[i];
        items = newItems;
        allocatedLength = allocatedLength == 0 ? 2 : allocatedLength * 2 ;
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
        String strRepr = "[";
        for (int i = 0; i < count; i++)
            strRepr += items[i] + ", ";
        return strRepr == "[" ? "[]" : strRepr.substring(0, strRepr.length() - 2) + "]";
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public int max() throws Exception {
        if (count == 0)
            throw new Exception();
        int max = items[0];
        for (int i = 1; i < count; i++) {
            if (items[i] > max)
                max = items[i];
        }
        return max;
    }

    public Array intersection(int[] arr) {
        var intersectArray = new Array(0);
        for (int i = 0; i < arr.length; i++) {
            if (this.indexOf(arr[i]) != -1)
                intersectArray.insert(arr[i]);
        }
        return intersectArray;
    }

    public void reverse() {
        var newItems = new int[count];
        for (int i = 0; i < count; i++)
            newItems[count - i - 1] = items[i];
        items = newItems;
    }

    public void insertAt(int item, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();
        if (count >= allocatedLength)
            doubleMemoAllocation();
        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];
        items[index] = item;
    }
}
