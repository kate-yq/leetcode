public class Q518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1;

        // but if switch the loops
        // the answer will be wrong
        // as 2+5 and 5+2 will count for twice in solution
        for (int j : coins){
            for (int i=1; i<=amount; i++){
                if (i-j >= 0){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[amount];
    }
}
