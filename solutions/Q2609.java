public class Q2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int zero = 0;
        int one = 0;
        boolean start = true;
        int max = 0;

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '0'){
                if (start){
                    max = Math.max(max, 2 * Math.min(zero, one));
                    zero = 0;
                    one = 0;
                    start = false;
                    zero++;
                } else {
                    zero++;
                }
            } else {
                start = true;
                one++;
            }
        }
        max = Math.max(max, 2 * Math.min(zero, one));
        return max;
    }
}
