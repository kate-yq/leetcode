class Q1140 {
    public int stoneGameII(int[] piles) {

        // record the suffix sum

        int[] suffixsum = new int[piles.length];
        suffixsum[piles.length-1] = piles[piles.length-1];

        for (int i = suffixsum.length - 2; i >= 0; i--) {
            suffixsum[i] = suffixsum[i+1] + piles[i];
        }

        int[][] dp = new int[piles.length][piles.length];

        return dfs(suffixsum, 1, 0, dp);
    }
    private int dfs(int[] sufsum, int m, int p, int[][] dp) {

        // last player takes all
        if (p + 2 * m >= sufsum.length) { 
            return sufsum[p];
        }

        if (dp[p][m] > 0) {
            return dp[p][m];
        }

        int res = 0;
        for (int i = 1; i <= 2 * m; i++) {

            // take max of all remaining - other player max take
            res = Math.max(res, sufsum[p] - dfs(sufsum, Math.max(i, m), p + i, dp));
        }
        dp[p][m] = res;
        return res;
    }
}