import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        char[] letters = s.toCharArray();
        Stack<Character> parentheses = new Stack<>();
        Stack<Integer> locations = new Stack<>();
        for (int i =0; i<letters.length; i++){
            if (letters[i] == '('){
                parentheses.add('(');
                locations.add(i);
            } else if (letters[i] == ')'){
                if (parentheses.empty()){
                    letters[i] = '\u0000';
                } else if (parentheses.pop()=='('){
                    locations.pop();
                } else {
                    letters[i] = '\u0000';
                }
                
            }
        }
        while (!parentheses.empty()){
            parentheses.pop();
            int temp = locations.pop();
            letters[temp] = '\u0000';
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<letters.length; i++){
            if (letters[i]=='\u0000'){
                continue;
            }
            result.append(letters[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String test_case_1 = "))((";
        String test_case_2 = "(ad(vfrdd(ed(sd)cs)csd))))";
        Q1249 mM = new Q1249();
        System.out.println("case 1(exp empty): \'"+mM.minRemoveToMakeValid(test_case_1)+"\'");
        System.out.println("case 2(exp advfrdd(ed(sd)cs)csd))): \'"+mM.minRemoveToMakeValid(test_case_2)+"\'");
    }
}