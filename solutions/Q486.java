public class Q486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;

        // dp[i][j][0] means the most points first mover can earn
        // between i..j inclusive
        // dp[i][j][1] means the most points second mover can earn
        // between i..j inclusive
        int[][][] dp = new int[n][n][2];
        // when i==j, first mover take all the remainings, second
        // mover got nothing
        for (int i=0; i<n; i++){
            dp[i][i][0] = nums[i];
        }

        for (int i=n-2; i>=0; i--){
            for (int j=i+1; j<n; j++){
                int left = nums[i]+dp[i+1][j][1];
                int right = nums[j]+dp[i][j-1][1];
                if (left>right){
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i+1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j-1][0];
                }
            }
        }

        return dp[0][n-1][0]>=dp[0][n-1][1];
    }
}
