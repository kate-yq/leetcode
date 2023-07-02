public class Q695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }

        if (grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        return dfs(grid, row - 1, col) + dfs(grid, row + 1, col)
                + dfs(grid, row, col - 1) + dfs(grid, row, col + 1) + 1;
    }
}
