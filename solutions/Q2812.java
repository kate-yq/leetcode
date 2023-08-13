import java.util.*;

public class Q2812 {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int[][] distances;
    int m, n;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.m = grid.size();
        this.n = grid.get(0).size();
        this.distances = new int[m][n];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        bfs(grid, rows, cols);

        int h = Math.min(distances[0][0], distances[m - 1][n - 1]);
        int l = 0;
        while (h > l) {
            int mid = (l + h + 1) / 2;
            boolean[][] visited = new boolean[m][n];
            if (canAchieve(mid, 0, 0, visited)) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }

    private void bfs(List<List<Integer>> nums, List<Integer> rows, List<Integer> cols) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows.size(); i++) {
            int row = rows.get(i);
            int col = cols.get(i);
            distances[row][col] = 0;
            q.add(new int[] { row, col });
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nextR = cur[0] + dir[0];
                int nextC = cur[1] + dir[1];
                if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n) {
                    continue;
                }
                if (distances[nextR][nextC] > distances[cur[0]][cur[1]] + 1) {
                    distances[nextR][nextC] = distances[cur[0]][cur[1]] + 1;
                    q.add(new int[] { nextR, nextC });
                }
            }
        }
    }

    private boolean canAchieve(int dis, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) {
            return false;
        }
        if (distances[row][col] < dis) {
            return false;
        }
        if (row == m - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;
        boolean ans = false;

        for (int[] dir : dirs) {
            int nextR = row + dir[0];
            int nextC = col + dir[1];
            ans |= canAchieve(dis, nextR, nextC, visited);
        }

        return ans;
    }
}
