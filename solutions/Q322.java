import java.util.Arrays;

class Q322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        Arrays.sort(coins);
        dp[0] = 0;
        // each element in dp represent a solution for the index. 
        // 0 means no money so mincoin is 0
        // next element will be based on previous solutions and +1
        // if no solution, the element will > amount, as initialized as amount+1

        for (int i = 1; i<amount+1; i++){
            for (int j : coins){
                if (j<= i){
                    dp[i] = Math.min(dp[i-j]+1, dp[i]);
                }
            }
        }

        if (dp[amount]>amount){
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args){
        int[] test_case_1 = {1, 2, 5};
        int[] test_case_2 = {2, 5};
        int[] test_case_3 = {2};
        Q322 cC = new Q322();
        System.out.println(cC.coinChange(test_case_1, 11));
        System.out.println(cC.coinChange(test_case_2, 6));
        System.out.println(cC.coinChange(test_case_3, 3));
    }
}