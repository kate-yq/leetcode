import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> elements = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                elements.add(s.charAt(i));
            } else {
                if (elements.size() == 0) {
                    return false;
                }
                char left = elements.pop();
                if (left == '(') {
                    if (s.charAt(i) == ')') {
                        continue;
                    }
                    return false;
                } else if (left == '[') {
                    if (s.charAt(i) == ']') {
                        continue;
                    }
                    return false;
                } else {
                    if (s.charAt(i) == '}') {
                        continue;
                    }
                    return false;
                }
            }
        }
        if (elements.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String test_case_1 = "()[]{(((([{}]))))}";
        String test_case_2 = "({(([{}]))))}";
        Q20 iV = new Q20();
        System.out.println("test case 1(exp true): " + iV.isValid(test_case_1));
        System.out.println("test case 2(exp false): " + iV.isValid(test_case_2));
    }
}
