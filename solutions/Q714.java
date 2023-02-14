public class Q714 {
    // high1 - low1 - fee + high2 - low2 - fee
    // high2 - low1 - fee
    // high1 -low2 -fee < 0 then 1 transaction
    // > 0 then 2 transactions
    // => high1 - fee <= low2  ===> 1 transaction
    // => high1 - fee > low2 ===> 2 transactions

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int curMin = prices[0];
        int curMax = prices[0];
        for (int i=1; i<prices.length; i++){
            if (prices[i]>=curMax){
                curMax = prices[i];
            } else if (prices[i] < curMax-fee){
                profit += Math.max(0, curMax-curMin-fee);
                curMin = prices[i];
                curMax = prices[i];
            } else if (prices[i] < curMin){
                profit += Math.max(0, curMax-curMin-fee);
                curMin = prices[i];
                curMax = prices[i];
            }
        }
        profit += Math.max(0, curMax-curMin-fee);
        return profit;
    }
}
