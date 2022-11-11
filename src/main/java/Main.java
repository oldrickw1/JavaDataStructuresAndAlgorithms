import DataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.deleteFirst();
        list.deleteLast();
        System.out.println(list.toString());

        list.addFirst(4);
        list.addLast(9);
        // [4,2,9]
        System.out.println(list);

        System.out.println(list.indexOf(2)); // 1
        System.out.println(list.getSize());

        var myList = new java.util.LinkedList<Integer>();
    }
}
