// import java.util.Arrays;

public class Q887 {
    // tipical logic
    // using dp to record max attempt with i eggs and j floor
    // time complexity: O(kn ^2)
    // lead to TLE

    // int[][] dp;

    // public int superEggDrop(int k, int n) {
    //     // record the max attempt with k eggs and n floor
    //     this.dp = new int[k+1][n+1];
    //     for (int[] row : dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return find(k,n);
    // }

    // private int find(int k, int n){
    //     if (k == 1){
    //         return n;
    //     }
    //     if (n == 0){
    //         return 0;
    //     }
    //     if (dp[k][n] != -1){
    //         return dp[k][n];
    //     }
    //     int res = Integer.MAX_VALUE;
    //     for (int i=1; i<=n; i++){
    //         res = Math.min(res, Math.max(find(k-1, i-1), find(k, n-i)) + 1);
    //     }
    //     dp[k][n] = res;
    //     return res;
    // }



    // change logic
    // reverse the dp, to record the max floor with i eggs and j drop
    // dp[i][j] = dp[i-1][j-1] + dp[i][j-1] + 1
    // cur_max_floor = if_broken_last_drop_floor + if_not_broken + 1(cur floor)

    // time complexity: O(kn)

    public int superEggDrop(int k, int n) {
        // max n drop, when do linear search
        int[][] dp = new int[k+1][n+1];

        int m = 0;

        while (dp[k][m] < n){
            m++;
            for (int i=1; i<=k; i++){
                dp[i][m] = dp[i-1][m-1] + dp[i][m-1] +1;
            }
        }

        return m;
    }
}
