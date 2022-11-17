package DataStructures;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void put(int item) {
        stack1.push(item);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int removedItem = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return removedItem;
    }

    @Override
    public String toString() {
        return "StackQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
