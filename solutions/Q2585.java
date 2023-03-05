public class Q2585 {

    public int waysToReachTarget(int target, int[][] types) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int n = types.length;

        // [i][j] number of ways to reach j using i combination
        long[][] dp = new long[n+1][target+1];

        dp[0][0] = 1;

        for (int i=1; i<=n; i++){
            for (int j=0; j<= target; j++){
                for (int k=0; k<=types[i-1][0]; k++){
                    // j - k*types[i-1][1] means the reachable target using i
                    if (j - k*types[i-1][1] >= 0){
                        dp[i][j] += dp[i-1][j-k*types[i-1][1]];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        return (int) dp[n][target];
    }

    public static void main(String[] args){
        Q2585 f = new Q2585();
        int[][] types = {
            {6,1},
            {3,2},
            {2,3}
        };
        System.out.println(f.waysToReachTarget(18, types));
    }
}
