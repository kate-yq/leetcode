public class Q1510 {
    public boolean winnerSquareGame(int n) {

        // with index stones, best strategy is to take how many
        int[] dp = new int[n+1];

        // with index stones, first mover can win?
        boolean[] firstMover = new boolean[n+1];

        for(int i=1; i<=Math.sqrt(n); i++){
            dp[i*i] = i*i;
            firstMover[i*i] = true;
        }
        return bestStrategy(dp, firstMover, n);
    }

    private boolean bestStrategy(int[] dp, boolean[] firstMover, int cur){
        if (cur<=0){
            return false;
        }
        if (dp[cur]>0){
            return firstMover[cur];
        }
        int i = 1;
        while (i*i <= cur) {
            dp[cur] = i*i;
            if (!bestStrategy(dp, firstMover, cur-i*i)){
                firstMover[cur] = true;
                break;
            }
            i++;
        }
        return firstMover[cur];
    }

    // no need to recursion
    // just use dp in increasing way

    // public boolean winnerSquareGame(int n) {
    //     boolean[] dp = new boolean[n + 1];
    //     for (int i = 0; i < n + 1; i++) {
    //         for (int k = 1; k * k <= i; k++) {
    //             if (dp[i - k * k] == false) {
    //                 dp[i] = true;
    //                 break;
    //             }
    //         }
    //     }
    //     return dp[n];
    // }
}
