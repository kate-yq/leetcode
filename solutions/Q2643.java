public class Q2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[2];
        for (int i=0; i<m; i++){
            int cur = 0;
            for (int j=0; j<n; j++){
                cur += mat[i][j];
            }
            if (cur > ans[1]){
                ans[0] = i;
                ans[1] = cur;
            }
        }
        return ans;
    }
}
