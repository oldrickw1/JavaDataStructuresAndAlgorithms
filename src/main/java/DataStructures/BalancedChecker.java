package DataStructures;

import java.util.HashMap;
import java.util.Stack;

public class BalancedChecker {
    public static boolean isBalanced(String str) {
        var brackets = new HashMap<Character, Character>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('<', '>');

        var stack = new Stack<Character>();

        for (char ch : str.toCharArray()) {
            if (brackets.containsKey(ch))
                stack.push(ch);
            if (!stack.isEmpty() && ch == brackets.get(stack.peek()))
                stack.pop();
        }
        return stack.isEmpty();
    }
}
