import java.util.LinkedList;
import java.util.Queue;

public class Q1730 {
    public int getFood(char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        boolean[][] visited = new boolean[rLen][cLen];
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (grid[r][c] == '*') {
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                    break;
                }
            }
        }
        final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int layer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (inBounds(grid, nr, nc) && !visited[nr][nc]) {
                        if (grid[nr][nc] == '#') {
                            return layer;
                        } else if (grid[nr][nc] == 'O') {
                            q.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            layer++;
        }
        return -1;
    }
    
    boolean inBounds(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 ||
            r >= grid.length ||
            c >= grid[0].length) {
            return false;
        }
        return true;
    }
}
