public class Q79 {
    boolean[][] visited;
    char[][] board;
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.visited = new boolean[row][col];
        this.board = board;
        
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (search(word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(String word, int start, int r, int c){
        if (this.board[r][c] != word.charAt(start)){
            return false;
        }
        if (this.visited[r][c]){
            return false;
        }
        if (start == word.length()-1){
            return true;
        }
        boolean found = false;
        this.visited[r][c] = true;
        if (r>0) {
            found = found || search(word, start+1, r-1, c);
        }
        if (r<this.row-1) {
            found = found || search(word, start+1, r+1, c);
        }
        if (c>0) {
            found = found || search(word, start+1, r, c-1);
        }
        if (c<this.col-1) {
            found = found || search(word, start+1, r, c+1);
        }
        this.visited[r][c] = false;
        return found;
    }
}
