import java.util.HashSet;

public class Q73 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            for (int col : cols){
                matrix[i][col] = 0;
            }
        }
        for (int i=0; i<matrix[0].length; i++){
            for (int row : rows){
                matrix[row][i] = 0;
            }
        }
    }
}
