import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    int M, N;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.M = heights.length;
        this.N = heights[0].length;

        // if can go to pacific, then true;
        boolean[][] Pacific = new boolean[M][N];
        Arrays.fill(Pacific[0], true);
        // if can go to atlantic, then true;
        boolean[][] Atlantic = new boolean[M][N];
        Arrays.fill(Atlantic[M-1], true);
        for (int i=0; i<M; i++){
            Pacific[i][0] = true;
            Atlantic[i][N-1] = true;
        }

        for (int i=0; i<N; i++){
            climb(0, i, Pacific, heights);
            climb(M-1, i, Atlantic, heights);
        }
        for (int i=0;i<M; i++){
            climb(i, 0, Pacific, heights);
            climb(i, N-1, Atlantic, heights);
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int m=0; m<M; m++){
            for (int n=0; n<N; n++){
                if (Pacific[m][n] && Atlantic[m][n]){
                    List<Integer> spot = new ArrayList<>();
                    spot.add(m);
                    spot.add(n);
                    results.add(spot);
                }
            }
        }
        return results;
    }

    private void climb(int m, int n, boolean[][] dfs, int[][] heights){
        if (m<0 || n<0 || m>=M || n>=N){
            return;
        }
        if (m>0) {
            if (!dfs[m-1][n] && heights[m-1][n]>=heights[m][n]){
                dfs[m-1][n] = true;
                climb(m-1, n, dfs, heights);
            }
        }
        if (n>0) {
            if (!dfs[m][n-1] && heights[m][n-1]>=heights[m][n]){
                dfs[m][n-1] = true;
                climb(m, n-1, dfs, heights);
            }
        }
        if (m<M-1) {
            if (!dfs[m+1][n] && heights[m+1][n]>=heights[m][n]){
                dfs[m+1][n] = true;
                climb(m+1, n, dfs, heights);
            }
        }
        if (n<N-1) {
            if (!dfs[m][n+1] && heights[m][n+1]>=heights[m][n]){
                dfs[m][n+1] = true;
                climb(m, n+1, dfs, heights);
            }
        }
        return;
    }
}
