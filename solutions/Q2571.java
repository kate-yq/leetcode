import java.util.Arrays;

public class Q2571 {
    public int minOperations(int n) {
        // target >= 1
        // record the minimum operations needed for each index
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        int m = 1;
        // dp[2^k] = 1
        while(m<=n){
            dp[m] = 1;
            m = m*2;
        }

        for (int i = 3; i<=n; i++){
            int k = 32 - Integer.numberOfLeadingZeros(i);
            if (dp[i] == 1){
                continue;
            }
            // if unequal, loop from 0 to k-1 to find the backward operation before reaching target
            // this loop finds out the forward-backword-forward situation
            for (int j = 0; j<k-1; j++){
                dp[i] = Math.min(dp[i], dp[i-(1<<(k-1))]+dp[(1<<j)]);
            }

            // this finds out the forward-backword situaiton
            // go beyond the target then go back
            if (((1<<k)-i<i)){
                dp[i] = Math.min(dp[i], dp[(1<<k)-i]+1);
            }
        }
        return dp[n];
    }
}
