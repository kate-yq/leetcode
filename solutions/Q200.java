public class Q200 {
    boolean[][] checked;

    public int numIslands(char[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            if (grid[0][0] == '1') {
                return 1;
            }
            return 0;
        }

        this.checked = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                } else if (!this.checked[i][j]) {
                    count++;
                    _check(grid, i, j);
                }
            }
        }
        return count;
    }

    private void _check(char[][] grid, int i, int j) {
        if (grid[i][j] == '0' || this.checked[i][j] == true) {
            return;
        }
        this.checked[i][j] = true;
        if (i > 0) {
            _check(grid, i - 1, j);
        }
        if (j > 0) {
            _check(grid, i, j - 1);
        }
        if (i < grid.length - 1) {
            _check(grid, i + 1, j);
        }
        if (j < grid[i].length - 1) {
            _check(grid, i, j + 1);
        }
        return;
    }

    public static void main(String[] args) {
        char[][] test_case_1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '0', '1', '0', '1', '0' },
                { '0', '0', '0', '0', '0' }
        };
        char[][] test_case_2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '1', '0' },
                { '0', '1', '0', '1', '0' },
                { '0', '0', '1', '0', '0' }
        };
        char[][] test_case_3 = {
                { '1' }
        };
        Q200 nI = new Q200();
        System.out.println("exp 1: " + nI.numIslands(test_case_1));
        System.out.println("exp 3: " + nI.numIslands(test_case_2));
        System.out.println("exp 1: " + nI.numIslands(test_case_3));
    }
}
