public class Q37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    boolean solve(char[][] board){
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] == '.'){
                    for(char p ='1';p <= '9';p++){
                        if(isValid(board,i,j,p)){
                            board[i][j] = p;
                            if(solve(board)) return true;
                            
                            else{
                            board[i][j] = '.';
                        }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
    boolean isValid(char[][] board , int row , int col , char val){
        for(int m = 0 ; m < 9 ; m++){
            if(board[row][m] == val) return false;
            if(board[m][col] == val) return false;
            if(board[3*(row/3) + m/3][3*(col/3) + m%3] == val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] test_case = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        Q37 solve = new Q37();
        solve.solveSudoku(test_case);

        for (int i=0; i<9; i++){
            System.out.print("[");
            for (int j=0; j<9; j++){
                System.out.print(test_case[i][j]+",");
            }
            System.out.println("]");
        }
    }
}
