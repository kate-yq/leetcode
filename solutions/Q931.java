class Q931 {
    public int minFallingPathSum(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];

        for (int j=0; j<width; j++){
            dp[0][j] = matrix[0][j];
        }

        for (int i=1; i<height; i++){
            for (int j=0; j<width; j++){
                dp[i][j] = findmin(dp, i, j) + matrix[i][j];
            }
        }
        int min = dp[height-1][0];
        for (int j=1; j<width; j++){
            min = Math.min(dp[height-1][j],min);
        }

        return min;
    }

    private int findmin(int[][] dp, int i, int j){
        if (i==0){
            return 0;
        }
        int min = dp[i-1][j];
        if (j > 0){
            min = Math.min(dp[i-1][j-1], min);
        }
        if (j<dp[0].length-1){
            min = Math.min(dp[i-1][j+1], min);
        }
        return min;
    }
}