import DataStructures.*;

public class Main {
    public static void main(String[] args) {
        var tree = new Tree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(24);
        tree.insert(26);
        tree.insert(14);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        System.out.println(tree.min());

    }
}


