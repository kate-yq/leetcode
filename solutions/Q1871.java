public class Q1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int preLoc = 0;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            // sliding window to record the total locations that can jump
            // to the current index
            if (i >= minJump && dp[i - minJump]){
                preLoc++;
            }
            if (i > maxJump && dp[i - maxJump - 1]){
                preLoc--;
            }
            dp[i] = preLoc > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}
