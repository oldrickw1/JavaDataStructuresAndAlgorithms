import DataStructures.LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.print(list);
        list.reverse();
        System.out.print(list);
    }
}
