import java.util.*;

public class Q2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        HashSet<Integer>[][] sets = new HashSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sets[i][j] = new HashSet<>();
                if (i > 0 && j > 0) {
                    sets[i][j].addAll(sets[i - 1][j - 1]);
                    sets[i][j].add(grid[i - 1][j - 1]);
                }
                res[i][j] = sets[i][j].size();
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sets[i][j] = new HashSet<>();
                if (i < m - 1 && j < n - 1) {
                    sets[i][j].addAll(sets[i + 1][j + 1]);
                    sets[i][j].add(grid[i + 1][j + 1]);
                }
                res[i][j] = Math.abs(res[i][j] - sets[i][j].size());
            }
        }

        return res;
    }
}
