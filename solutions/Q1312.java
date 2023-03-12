public class Q1312 {
    public int minInsertions(String s) {
        int n = s.length();

        // dp[i][j] means the MI for substring i->j, inclusive
        // i<=j (must be)
        // when i==j, dp[i][j] = 0
        int[][] dp = new int[n][n];

        for (int i=n-1; i>=0; i--){
            dp[i][i] = 0;
            for (int j=i+1; j<n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
                }
            }
        }
        return dp[0][n-1];
    }
}
