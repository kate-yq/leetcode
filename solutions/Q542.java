import java.util.Arrays;

public class Q542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] nearest = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(nearest[i], m + n);
        }
        // go through each cell from top left to bottom right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    nearest[i][j] = 0;
                } else {
                    if (i > 0) {
                        nearest[i][j] = Math.min(nearest[i][j], nearest[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        nearest[i][j] = Math.min(nearest[i][j], nearest[i][j + 1] + 1);
                    }
                }
            }
        }
        // go through each cell again back words
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    nearest[i][j] = Math.min(nearest[i][j], nearest[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    nearest[i][j] = Math.min(nearest[i][j], nearest[i][j - 1] + 1);
                }
            }
        }
        return nearest;
    }
}
