public class Q7 {
    public int reverse(int x) {
        int ans = 0;
        int sign = 1;
        if (x<0){
            sign = -1;
            x = Math.abs(x);
        }
        while(x>0){
            int digit = x%10;
            if (ans > (Integer.MAX_VALUE - digit)/10){
                return 0;
            }
            ans = ans*10 + digit;
            x = x/10;
        }
        return ans*sign;
    }
}
