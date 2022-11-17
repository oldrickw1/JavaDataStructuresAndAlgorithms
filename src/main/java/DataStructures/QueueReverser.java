package DataStructures;

import java.util.Stack;

public class QueueReverser {
    public static void reverse(java.util.Queue<Integer> queue) {
        var stack = new Stack<Integer>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
