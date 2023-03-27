public class Q651 {
    public int maxA(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++){
            // press A
            dp[i] = dp[i-1]+1;
            for (int j = i-2; j>0; j--){
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
            }
        }
        return dp[n];
    }
}
