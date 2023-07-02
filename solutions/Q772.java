import java.util.*;

public class Q772 {
    public int calculate(String s) {
        Deque<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                q.add(c);
            }
        }

        return calculate(q);
    }

    public int calculate(Deque<Character> q) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculate(q);
            }
            if (!Character.isDigit(c) || q.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int mul = num * stack.pop();
                    stack.push(mul);
                } else if (sign == '/') {
                    int div = stack.pop() / num;
                    stack.push(div);
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
