import DataStructures.LinkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.createWithLoop();
        System.out.println(list.hasLoop());
    }
}
