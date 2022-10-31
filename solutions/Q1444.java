public class Q1444 {
    Integer[][][] dp;
    int[][] presum;
    int ROW, COL;

    public int ways(String[] pizza, int k) {
        this.ROW = pizza.length;
        this.COL = pizza[0].length();

        // presum records the #apple staring from current space to the down-right corner
        this.presum = new int[ROW+1][COL+1];
        for (int i=ROW-1; i>=0; i--){
            for (int j=COL-1; j>=0; j--){
                presum[i][j] = presum[i+1][j]+presum[i][j+1] - presum[i+1][j+1];
                if (pizza[i].charAt(j)=='A'){
                    presum[i][j]++;
                }
            }
        }

        // dp records the number of ways after k cuts, at row,col as top-left corner
        this.dp = new Integer[k][ROW][COL];
        return dfs(k-1, 0, 0);
    }

    private int dfs(int k, int row, int col){
        // the remaining piece has less than k apple -> invalid
        // the remaining piece has no apple -> invalid
        if (this.presum[row][col]<k || this.presum[row][col]==0){
            return 0;
        }
        // found a valid way after k-1 cuts
        if (k == 0){
            return 1;
        }
        // if calculated, just return the result
        if(dp[k][row][col]!= null){
            return dp[k][row][col];
        }
        int ans = 0;
        for(int r=row+1; r<this.ROW; r++){
            // between row and r, there are apples, hence can cut horizontal
            if (this.presum[row][col]-this.presum[r][col]>0){
                ans = (ans+ dfs(k-1, r, col)) % 1000000007;
            }
        }
        for(int c=col+1; c<this.COL; c++){
            // between col and c, there are apples, hence can cut vertical
            if (this.presum[row][col]-this.presum[row][c]>0){
                ans = (ans + dfs(k-1, row, c)) % 1000000007;
            }
        }
        dp[k][row][col] = ans;
        return ans;
    }
}
