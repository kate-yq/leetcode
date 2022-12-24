import java.util.HashSet;

public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        // check if duplicates in rows and cols
        for (int i =0; i<9; i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for (int j=0; j<9; j++){
                if (board[i][j] != '.'){
                    if (row.contains(board[i][j])){
                        return false;
                    } else {
                        row.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.'){
                    if (col.contains(board[j][i])){
                        return false;
                    } else {
                        col.add(board[j][i]);
                    }
                }
            }
        }
        // check if duplicates in sequares
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                HashSet<Character> square = new HashSet<>();
                for (int m=0; m<3; m++){
                    for (int n=0; n<3; n++){
                        if (board[i*3 + m][j*3 + n] != '.'){
                            if (square.contains(board[i*3 + m][j*3 + n])){
                                return false;
                            } else {
                                square.add(board[i*3 + m][j*3 + n]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
