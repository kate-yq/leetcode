import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> results = new ArrayList<>();
        boolean[][] visited = new boolean[row][col];
        int i=0;
        int j=0;
        results.add(matrix[i][j]);
        visited[i][j] = true;
        while (true){
            while (j<col-1 && !visited[i][j+1]){
                j++;
                results.add(matrix[i][j]);
                visited[i][j] = true;
            }
            if (i==row-1 || visited[i+1][j]){
                break;
            }
            while (i<row-1 && !visited[i+1][j]){
                i++;
                results.add(matrix[i][j]);
                visited[i][j] = true;
            }
            if (j==0 || visited[i][j-1]){
                break;
            }
            while (j>0 && ! visited[i][j-1]){
                j--;
                results.add(matrix[i][j]);
                visited[i][j] = true;
            }
            if (i==0 || visited[i-1][j]){
                break;
            }
            while (i>0 && ! visited[i-1][j]){
                i--;
                results.add(matrix[i][j]);
                visited[i][j] = true;
            }
            if (j==col-1 || visited[i][j+1]){
                break;
            }
        }
        return results;
    }
}
