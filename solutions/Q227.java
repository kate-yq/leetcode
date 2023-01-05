import java.util.Stack;

public class Q227 {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int sign = 1;
        int part = 0;
        int index = 0;
        while (index < s.length()){
            if (s.charAt(index) == ' '){
                index++;
            } else if (s.charAt(index) == '+'){
                nums.add(sign * part);
                sign = 1;
                part = 0;
                index++;
            } else if (s.charAt(index) == '-'){
                nums.add(sign * part);
                sign = -1;
                part = 0;
                index++;
            } else if (s.charAt(index) == '*'){
                index++;
                int cur = 0;
                while (index < s.length()){
                    if (Character.isDigit(s.charAt(index))){
                        cur = cur*10+s.charAt(index)-'0';
                        index++;
                    } else if (s.charAt(index)==' '){
                        index++;
                        continue;
                    } else {
                        break;
                    }
                }
                part = part*cur;
            } else if (s.charAt(index) == '/'){
                index++;
                int cur = 0;
                while (index < s.length()){
                    if (Character.isDigit(s.charAt(index))){
                        cur = cur*10+s.charAt(index)-'0';
                        index++;
                    } else if (s.charAt(index)==' '){
                        index++;
                        continue;
                    } else {
                        break;
                    }
                }
                part = part/cur;
            } else {
                part = part*10 + s.charAt(index)-'0';
                index++;
            }
        }
        nums.add(part*sign);
        int sum = 0;
        while(!nums.isEmpty()){
            sum += nums.pop();
        }
        return sum;
    }
}
