import java.util.Arrays;

public class Q188 {
    public int maxProfit(int k, int[] prices) {
        int[] costs = new int[k];
        int[] profits = new int[k];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i=0; i<prices.length; i++){
            costs[0] = Math.min(prices[i], costs[0]);
            profits[0] = Math.max(profits[0], prices[i]-costs[0]);
            for(int j=1; j<k; j++){
                costs[j] = Math.min(prices[i]-profits[j-1], costs[j]);
                profits[j] = Math.max(prices[i]-costs[j], profits[j]);
            }
        }

        return profits[k-1];
    }
}
