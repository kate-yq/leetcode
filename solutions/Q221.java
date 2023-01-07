public class Q221 {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxlen = 0;

        // for convenience, we add an extra all zero column and row
        // outside of the actual dp table, to simpify the transition

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }
        return maxlen * maxlen;
    }

    // brute force
    // very slow

    // char[][] matrix;
    // int m,n;

    // public int maximalSquare(char[][] matrix) {
    //     this.matrix = matrix;
    //     this.m = matrix.length;
    //     this.n = matrix[0].length;

    //     int maxlen = 0;
    //     for (int row=0; row<m; row++){
    //         for (int col=0; col<n; col++){
    //             if (matrix[row][col] == '1'){
    //                 int len = findmaxlen(row, col, 1);
    //                 maxlen = Math.max(maxlen, len);
    //             }
    //         }
    //     }
    //     return maxlen*maxlen;
    // }

    // private int findmaxlen(int row, int col, int len){
    //     int max = len;
    //     if (row+len<m && col+len<n){
    //         for (int i=col; i<=col+len; i++){
    //             if (matrix[row+len][i] == '0'){
    //                 return max;
    //             }
    //         }
    //         for (int i=row; i<=row+len; i++){
    //             if (matrix[i][col+len] == '0'){
    //                 return max;
    //             }
    //         }
    //         max = findmaxlen(row, col, len+1);
    //     }
    //     return max;
    // }
}
