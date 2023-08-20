class Q289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] neighbors = new int[m][n];
        int[][] dirs = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (row < 0 || col < 0 || row >= m || col >= n) {
                            continue;
                        }
                        neighbors[row][col]++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if (neighbors[i][j] < 2 || neighbors[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (neighbors[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        return;
    }
}