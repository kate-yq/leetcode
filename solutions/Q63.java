public class Q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] memo = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    memo[i][j] = 1;
                } else if (obstacleGrid[i - 1][j - 1] == 0) {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }

        return memo[m][n];
    }
}
