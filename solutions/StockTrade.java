public class StockTrade {
    public int maxProfit_all_in_one(int max_k, int[] prices, int cooldown, int fee){
        int n = prices.length;

        if (max_k > n/2){
            return maxProfit_no_limit(prices, cooldown, fee);
        }

        int[][][] dp = new int[n][max_k+1][2];
        // k = 0, no quota to trade
        for (int i=0; i<n; i++){
            dp[i][0][0] = 0; // not holding anything
            dp[i][0][1] = Integer.MIN_VALUE; // impossible
        }

        for (int i=0; i<n; i++){
            for (int k=1; k<=max_k; k++){
                // first day
                if (i == 0){
                    // not holding anything
                    dp[i][k][0] = 0; 
                    // buy on first day
                    dp[i][k][1] = -prices[i] - fee;
                    continue;
                }
                // plus cooldown will buy on negative day if there is
                if (i-cooldown<=0){
                    // not holding as prev day, or sell on cur day
                    dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                    // hold as prev day, or first buy
                    dp[i][k][1] = Math.max(dp[i-1][k][1], - prices[i] - fee);
                    continue;
                }

                // not first buy with cooldown 
                // not holding as prev day, or sell on cur day
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                // hold as prev day, buy on cur day with cooldown
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-cooldown-1][k-1][0] - prices[i] - fee);
            }
        }
        
        // return with max trade and no stock on hand
        return dp[n-1][max_k][0];
    }

    private int maxProfit_no_limit(int[] prices, int cooldown, int fee){
        // no influence by k
        int n = prices.length;
        int[][] dp = new int[n][2];

        // base case
        // not hold on first day
        dp[0][0] = 0;
        // buy on first day
        dp[0][1] = -prices[0] - fee;

        for (int i=1; i<n; i++){
            // with cooldown will buy on negative day if there is
            if (i-cooldown <=0){
                // not hold as prev day, or sell on cur day
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                // hold as prev day, or first buy
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]-fee);
            }

            // not first buy with cooldown
            // not hold as prev day, or sell on cur day
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // hold as prev day, or buy on cur day with cooldown
            dp[i][1] = Math.max(dp[i-1][1], dp[i-cooldown-1][0] - prices[i] - fee);
        }

        // return last day with no stock on hand
        return dp[n-1][0];
    }
}
