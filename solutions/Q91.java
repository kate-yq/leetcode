import java.util.HashMap;

public class Q91 {

    public int numDecodings(String s) {
        HashMap<Character, Integer> MAP = new HashMap<>();
        MAP.put('0', 0);
        MAP.put('1', 1);
        MAP.put('2', 2);
        MAP.put('3', 3);
        MAP.put('4', 4);
        MAP.put('5', 5);
        MAP.put('6', 6);
        MAP.put('7', 7);
        MAP.put('8', 8);
        MAP.put('9', 9);

        // 1 letter case;
        if (s.length() == 1){
            if (s.equals("0")){
                return 0;
            } else {
                return 1;
            }
        }

        // 2 letter case;
        int[] dp = new int[s.length()];    // index represents the first n+1 letter, value is the ways of decoding
        if (MAP.get(s.charAt(0))==0){
            return 0;
        } else if (MAP.get(s.charAt(0))==1) {
            if (MAP.get(s.charAt(1))==0){
                dp[0] = 1;
                dp[1] = 1;
            } else {
                dp[0] = 1;
                dp[1] = 2;
            }
        } else if (MAP.get(s.charAt(0))==2){
            if (MAP.get(s.charAt(1))>0 && MAP.get(s.charAt(1))<7){
                dp[0] = 1;
                dp[1] = 2;
            } else {
                dp[0] = 1;
                dp[1] = 1;
            }
        } else if(MAP.get(s.charAt(1))== 0){
            return 0;
        } else {
            dp[0] = 1;
            dp[1] = 1;
        }

        // 3 or upper
        for (int i = 2; i < dp.length; i++){
            if (MAP.get(s.charAt(i))==0){
                if (MAP.get(s.charAt(i-1))==1 || MAP.get(s.charAt(i-1))==2){
                    dp[i] = dp[i-2];
                    dp[i-1] = dp[i-2];
                } else {
                    return 0;
                }
            } else if (MAP.get(s.charAt(i)) < 7){
                if (MAP.get(s.charAt(i-1))==1 || MAP.get(s.charAt(i-1))==2){
                    dp[i] = dp[i-1]+dp[i-2];
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                if (MAP.get(s.charAt(i-1))==1){
                    dp[i] = dp[i-1]+dp[i-2];
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[dp.length-1];
    } 
}
