public class Q130 {
    boolean[][] mark;
    int m,n;

    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.mark = new boolean[m][n];

        for (int i=0; i<m; i++){
            if (board[i][0] == 'O'){
                dfs(i,0, board);
            }
            if (board[i][n-1] == 'O'){
                dfs(i,n-1, board);
            }
        }

        for (int j=1; j<n-1; j++){
            if (board[0][j] == 'O'){
                dfs(0,j, board);
            }
            if (board[m-1][j] == 'O'){
                dfs(m-1,j, board);
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (!mark[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board){
        if (row < 0 || row >= m || col < 0 || col >= n){
            return;
        }
        if (board[row][col] == 'X'){
            return;
        }
        if (mark[row][col]){
            return;
        }

        mark[row][col] = true;
        dfs(row-1, col, board);
        dfs(row+1, col, board);
        dfs(row, col-1, board);
        dfs(row, col+1, board);
    }
}
