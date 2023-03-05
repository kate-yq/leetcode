import java.util.Stack;

public class Solution7 {
    // remove all adj same num
    // repeat until no more
    // s <= 10^5

    // "" => ""

    public String removeDuplicates(String s) {
        // cabbac
        // Stack: each letter
        int i =0;
        Stack<Character> stack = new Stack<>();
        while(i< s.length()){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                } else {
                char prev = stack.peek();
                if (s.charAt(i) == prev){
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            i++;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}
