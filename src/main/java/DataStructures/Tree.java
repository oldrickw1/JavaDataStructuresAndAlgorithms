package DataStructures;

public class Tree {
    private Node root;

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    public void insert(int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
                continue;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else
                return true;
        }
        return false;
    }

    public void breadthFirst() {
        if (root == null)
            return;
        breadthRecursive(root);
    }

    private void breadthRecursive(Node current) {
        System.out.println(current.value);
        printChildren(current);
        breadthRecursive(current.leftChild);
        breadthRecursive(current.rightChild);


    }

    private void printChildren(Node current) {
        if (current.leftChild != null)
            System.out.println(current.leftChild);
        if (current.rightChild != null)
            System.out.println(current.rightChild);
    }


    public void depthFirstPreOrder() {
        preOrderRecursively(root);
    }

    public void depthFirstInOrder() {
        inOrderRecursively(root);
    }

    public void depthFirstPostOrder() {
        postOrderRecursively(root);
    }

    private void preOrderRecursively(Node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.value);
        preOrderRecursively(current.leftChild);
        preOrderRecursively(current.rightChild);
    }

    private void inOrderRecursively(Node current) {
        if (current == null) {
            return;
        }

        inOrderRecursively(current.leftChild);
        System.out.println(current);
        inOrderRecursively(current.rightChild);
    }

    private void postOrderRecursively(Node current) {
        if (current == null) {
            return;
        }

        inOrderRecursively(current.leftChild);
        inOrderRecursively(current.rightChild);
        System.out.println(current);
    }
}