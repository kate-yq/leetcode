public class Q329 {
    int[][] results;
    int m,n;

    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.results = new int[m][n];

        int ans = 1;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                ans = Math.max(ans, longestPath(matrix, i, j));
            }
        }
        return ans;
    }

    private int longestPath(int[][] matrix, int row, int col){
        if (results[row][col] != 0){
            return results[row][col];
        }
        int max = 1;
        if (row > 0){
            if (matrix[row-1][col] > matrix[row][col]){
                max = Math.max(max, 1+longestPath(matrix, row-1, col));
            }
        }
        if (row < m-1){
            if (matrix[row+1][col] > matrix[row][col]){
                max = Math.max(max, 1+longestPath(matrix, row+1, col));
            }
        }
        if (col > 0){
            if (matrix[row][col-1] > matrix[row][col]){
                max = Math.max(max, 1+longestPath(matrix, row, col-1));
            }
        }
        if (col < n-1){
            if (matrix[row][col+1] > matrix[row][col]){
                max = Math.max(max, 1+longestPath(matrix, row, col+1));
            }
        }
        results[row][col] = max;
        return max;
    }
}
