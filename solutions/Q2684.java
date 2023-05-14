public class Q2684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;

        int[][] dp = new int[m][n];

        for (int j = 1; j<n; j++){
            for (int i = 0; i<m; i++){
                if (i>0 && grid[i][j]>grid[i-1][j-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
                if (grid[i][j]>grid[i][j-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+1);
                }
                if (i<m-1 && grid[i][j]>grid[i+1][j-1]){
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1]+1);
                }
                max = Math.max(max, dp[i][j]);
            }
            if (max < j){
                break;
            }
        }

        return max;
    }
}
