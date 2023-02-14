public class Q1049 {
    public int lastStoneWeightII(int[] stones) {
        // devide these stones into 2 subsets
        // with sum close to each other
        int sum = 0;
        for (int s : stones){
            sum += s;
        }

        // record wether index weight is achhievable
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;

        int subsum = 0;
        for (int s : stones){
            subsum += s;
            for (int i = Math.min(sum/2, subsum); i>=s; i--){
                dp[i] = dp[i] | dp[i-s];
            }
        }
        for (int i = sum/2; i>=0; i--){
            if (dp[i]){
                return sum - i*2;
            }
        }
        return 0;
    }
}
