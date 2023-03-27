class Q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] expanded = new int[n+2];
        expanded[0] = 1;
        expanded[n+1] = 1;
        for (int i=1; i<=n; i++){
            expanded[i] = nums[i-1];
        }

        // dp[i][j] = maxCoins between i..j exclusive
        // 0 & n+1 not included, so works
        // dp[i][j] = dp[i][k] + dp[k][j] + expaned[i]*expanded[k]*expanded[j]
        int[][] dp = new int[n+2][n+2];
        for (int i=n+1; i>=0; i--){
            for (int j=i+2; j<n+2; j++){
                for (int k=i+1; k<j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k]+dp[k][j]+
                        expanded[i]*expanded[k]*expanded[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}