import java.util.Stack;

public class Q1021 {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder s2 = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                if (!stack.isEmpty()){
                    s2.append('(');
                }
                stack.push('(');
            } else {
                stack.pop();
                if (!stack.isEmpty()){
                    s2.append(')');
                }
            }
        }
        return s2.toString();
    }
}
