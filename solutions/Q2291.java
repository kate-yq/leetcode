public class Q2291 {

    public int maximumProfit(int[] present, int[] future, int budget) {
        // dp to record with each budget, how many profit can I earn
        int[] dp = new int[budget+1];
        for (int i=0; i<present.length; i++){
            for (int j=budget; j>=0; j--){
                if (j>=present[i] && present[i]<future[i]){
                    dp[j] = Math.max(dp[j], dp[j-present[i]]+future[i]-present[i]);
                }
            }
        }
        return dp[budget];
    }
}
