public class Q1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] suffixsum = new int[n];
        suffixsum[n-1] = stoneValue[n-1];

        for(int i=n-2; i>=0; i--){
            suffixsum[i] = stoneValue[i] + suffixsum[i+1];
        }

        Integer[] dp = new Integer[n];
        dp[n-1] = stoneValue[n-1];

        int alice = bestStrategy(suffixsum, 0, dp);
        if (suffixsum[0] - alice > alice){
            return "Bob";
        } else if (suffixsum[0] - alice < alice){
            return "Alice";
        } else {
            return "Tie";
        }
    }

    private int bestStrategy(int[] sufsum, int cur, Integer[] dp){
        if (cur >= sufsum.length){
            return 0;
        }

        if (dp[cur] != null){
            return dp[cur];
        }

        int res = Integer.MIN_VALUE;
        for (int i=1; i<=3; i++){
            res = Math.max(res, sufsum[cur] - bestStrategy(sufsum, cur+i, dp));
        }
        dp[cur] = res;
        return res;
    }
}
