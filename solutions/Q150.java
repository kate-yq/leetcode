import java.util.HashSet;
import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        HashSet<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        Stack<Integer> values = new Stack<>();
        Integer cur = Integer.valueOf(tokens[0]);
        for (int i=0; i<tokens.length; i++){
            if (!operations.contains(tokens[i])){
                values.add(Integer.valueOf(tokens[i]));
            } else {
                int a = values.pop();
                int b = values.pop();
                cur = operate(b, a, tokens[i]);
                values.add(cur);                
            }
        }
        return cur;
    }

    private int operate(int front, int back, String op){
        if (op.equals("+")){
            return front+back;
        }
        if (op.equals("-")){
            return front-back;
        }
        if (op.equals("*")){
            return front*back;
        }
        if (op.equals("/")){
            return front/back;
        }
        return 0;
    }
}
