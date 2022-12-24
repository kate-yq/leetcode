public class Q8 {
    public int myAtoi(String s) {
        int sign = 1;
        int number = 0;
        boolean started = false;
        for (int i=0; i<s.length(); i++){
            if (started){
                if (!Character.isDigit(s.charAt(i))){
                    return number*sign;
                } else {
                    if (number > Integer.MAX_VALUE/10 || 
                        (number == Integer.MAX_VALUE/10 && (s.charAt(i) - '0')>Integer.MAX_VALUE%10)){
                            if (sign == 1){
                                return Integer.MAX_VALUE;
                            } else {
                                return Integer.MIN_VALUE;
                            }
                        }
                    number = number*10 + s.charAt(i) - '0';
                }
            } else if (s.charAt(i)=='-'){
                sign = -1;
                started = true;
            } else if (s.charAt(i)=='+'){
                started = true;
            } else if (Character.isDigit(s.charAt(i))){
                started = true;
                number = number*10 + s.charAt(i) - '0';
            } else if (s.charAt(i)==' ') {
                continue;
            } else {
                return 0;
            }
        }
        return number * sign;
    }
}
