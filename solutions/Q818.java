import java.util.Arrays;

public class Q818 {
    public int racecar(int target) {
        // target >= 1
        // record the minimum operations needed for each index
        int[] dp = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;
        // dp[2^k-1] = k
        for (int i = 3; i<=target; i++){
            // k is the log2 rounding to nearest int?
            // when operation is k, the distance is 2^k-1
            int k = 32 - Integer.numberOfLeadingZeros(i);
            if (i == (1<<k) -1){
                dp[i] = k;
                continue;
            }
            // if unequal, loop from 0 to k-1 to find the backward operation before reaching target
            // this loop finds out the forward-backword-forward situation
            for (int j = 0; j<k-1; j++){
                dp[i] = Math.min(dp[i], k-1+j+2+dp[i-(1<<(k-1))+(1<<j)]);
            }

            // this finds out the forward-backword situaiton
            // go beyond the target then go back
            if (((1<<k) -1 -i<i)){
                dp[i] = Math.min(dp[i], dp[(1<<k)-1-i]+k+1);
            }
        }
        return dp[target];
    }
}
