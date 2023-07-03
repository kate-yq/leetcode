import java.util.Stack;

public class Q2696 {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                if (stack.isEmpty() || stack.peek() != 'A') {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == 'D') {
                if (stack.isEmpty() || stack.peek() != 'C') {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.size();
    }
}
