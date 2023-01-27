import java.util.Arrays;
import java.util.Stack;

public class Q2297 {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[n-1] = 0;
        Stack<Integer> increase = new Stack<>();
        Stack<Integer> decrease = new Stack<>();
        for (int i=n-1; i>=0; i--){
            // check if the current one <= peek()
            while (!increase.isEmpty() && nums[i]>nums[increase.peek()]){
                increase.pop();
            }
            if (!increase.isEmpty()){
                dp[i] = Math.min(dp[i], dp[increase.peek()]+costs[increase.peek()]);
            }
            increase.add(i);
            // check if the current one >peek()
            while (!decrease.isEmpty() && nums[i]<=nums[decrease.peek()]){
                decrease.pop();
            }
            if (!decrease.isEmpty()){
                dp[i] = Math.min(dp[i], dp[decrease.peek()]+costs[decrease.peek()]);
            }
            decrease.add(i);
        }
        return dp[0];
    }
}
