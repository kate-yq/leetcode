import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q212 {
    HashSet<String> dictionay;
    int ROW, COL;
    char[][] board;
    List<String> results;

    public List<String> findWords(char[][] board, String[] words) {
        this.dictionay = new HashSet<>();
        for (int i=0; i<words.length; i++){
            this.dictionay.add(words[i]);
        }
        this.board = board;
        this.ROW = board.length;
        this.COL = board[0].length;
        this.results = new ArrayList<>();

        boolean[][] checked = new boolean[ROW][COL];
        
        for (int row=0; row<ROW; row++){
            for (int col = 0; col< COL; col++){
                String word = "";
                _search(row, col, checked, word);
            }
        }
        return results;
    }

    private void _search(int row, int col, boolean[][] checked, String word){
        if (checked[row][col]){
            return;
        }
        word = word+board[row][col];
        checked[row][col] = true;
        if (this.dictionay.contains(word)){
            this.results.add(word);
        }
        if (row>0){
            _search(row-1, col, checked, word);
            checked[row-1][col] = false;
        }
        if (row<ROW-1){
            _search(row+1, col, checked, word);
            checked[row+1][col] = false;
        }
        if (col>0){
            _search(row, col-1, checked, word);
            checked[row][col-1] = false;
        }
        if (col<COL-1){
            _search(row, col+1, checked, word);
            checked[row][col+1] = false;
        }
        checked[row][col] = false;
    }
}
