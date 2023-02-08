import java.util.LinkedList;
import java.util.Queue;

public class Q1091 {
    int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
    int n;
    int[][] grid;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        if (grid[0][0] != 0){
            return -1;
        }
        dp[0][0] = 1;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0,0});
        while(!bfs.isEmpty()){
            int[] cur = bfs.poll();
            for (int i=0; i<8; i++){
                if (isValid(cur[0]+row[i], cur[1]+col[i])){
                    if (dp[cur[0]+row[i]][cur[1]+col[i]] > dp[cur[0]][cur[1]]+1){
                        bfs.add(new int[]{cur[0]+row[i], cur[1]+col[i]});
                        dp[cur[0]+row[i]][cur[1]+col[i]] = dp[cur[0]][cur[1]]+1;
                    }
                }
            }
        }
        return dp[n-1][n-1] == Integer.MAX_VALUE ? -1:dp[n-1][n-1];
    }

    private boolean isValid(int r, int c){
        if (r<0 || r>=n || c<0 || c>=n){
            return false;
        }
        if (grid[r][c] != 0){
            return false;
        }
        return true;
    }
}
