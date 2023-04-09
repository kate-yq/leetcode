import java.util.*;

public class Q2617 {
    public int minimumVisitedCells(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Set<Integer>> setX = new ArrayList<>();
        List<Set<Integer>> setY = new ArrayList<>();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new TreeSet<>();
            for (int j = 0; j < m; j++) {
                set.add(j);
            }
            setX.add(set);
        }
        
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(i);
            }
            setY.add(set);
        }
        
        Queue<int[]> q = new LinkedList<>();
        dp[0][0] = 1;
        q.offer(new int[]{0, 0});
        setX.get(0).remove(0);
        setY.get(0).remove(0);
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            
            Queue<int[]> elist = new LinkedList<>();
            Set<Integer> row = setX.get(x);
            Set<Integer> col = setY.get(y);
            
            int xx = 0;
            int yy = grid[x][y] + y;
            Iterator<Integer> it = row.iterator();

            while (it.hasNext()) {
                int colIndex = it.next();
                if (colIndex <= yy) {
                    dp[x][colIndex] = dp[x][y] + 1;
                    q.offer(new int[]{x, colIndex});
                    elist.offer(new int[]{x, colIndex});
                    it.remove();
                    col.remove(x);
                } else {
                    break;
                }
            }
            
            while (!elist.isEmpty()) {
                int[] next = elist.poll();
                xx = next[0];
                yy = next[1];
                setX.get(xx).remove(yy);
                setY.get(yy).remove(xx);
            }

            xx = grid[x][y] + x;
            it = col.iterator();

            while (it.hasNext()) {
                int rowIndex = it.next();
                if (rowIndex <= xx) {
                    dp[rowIndex][y] = dp[x][y] + 1;
                    q.offer(new int[]{rowIndex, y});
                    elist.offer(new int[]{rowIndex, y});
                    it.remove();
                    row.remove(y);
                } else {
                    break;
                }
            }

            while (!elist.isEmpty()) {
                int[] next = elist.poll();
                xx = next[0];
                yy = next[1];
                setX.get(xx).remove(yy);
                setY.get(yy).remove(xx);
            }
        }

        return dp[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][m - 1];






        // original answer: TLE 

        // int m = grid.length;
        // int n = grid[0].length;
        // int[][] dp = new int[m][n];

        // for (int[] row : dp){
        //     Arrays.fill(row, 1000000);
        // }

        // dp[0][0] = 1;

        // for (int i=0; i<m; i++){
        //     for (int j=0; j<n; j++){
        //         for (int k = 1; k <= grid[i][j] && (i+k<m || j+k<n); k++){
        //             if (i+k<m){
        //                 dp[i+k][j] = Math.min(dp[i][j] + 1, dp[i+k][j]);
        //             }
        //             if (j+k<n){
        //                 dp[i][j+k] = Math.min(dp[i][j] + 1, dp[i][j+k]);
        //             }
        //         }
        //     }
        // }
        // return dp[m-1][n-1] < 1000000? dp[m-1][n-1] : -1;
    }
}
