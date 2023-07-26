public class Q688 {
    int[][] dirs = {
            { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }
    };

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0;

        for (int move = 0; move < k; move++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[move][i][j] == 0) {
                        continue;
                    }
                    for (int[] dir : dirs) {
                        int curR = i + dir[0];
                        int curC = j + dir[1];
                        if (curR < 0 || curR >= n || curC < 0 || curC >= n) {
                            continue;
                        }
                        dp[move + 1][curR][curC] += dp[move][i][j] / 8.0;
                    }
                }
            }
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[k][i][j];
            }
        }
        return ans;
    }
}
