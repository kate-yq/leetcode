import java.util.Arrays;

class Q62 {
    public int uniquePaths(int m, int n) {
        // m: row; n: col
        // dp representing the possible ways till the current space
        // equals left + top
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int row=1; row < m; row++){
            dp[row][0] = 1;
            for (int col = 1; col < n; col++){
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        return dp[m-1][n-1];
    }
}