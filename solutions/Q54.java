import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int upBond = 0;
        int lowBond = m-1;
        int leftBond = 0;
        int rightBond = n-1;

        List<Integer> ans = new ArrayList<>();
        while (ans.size() < m*n){
            if (upBond <= lowBond){
                for (int i=leftBond; i<=rightBond; i++){
                    ans.add(matrix[upBond][i]);
                }
                upBond++;
            }

            if (rightBond >= leftBond){
                for (int i=upBond; i<=lowBond; i++){
                    ans.add(matrix[i][rightBond]);
                }
                rightBond--;
            }

            if (lowBond >= upBond){
                for (int i=rightBond; i>=leftBond; i--){
                    ans.add(matrix[lowBond][i]);
                }
                lowBond--;
            }

            if (leftBond <= rightBond){
                for (int i=lowBond; i>=upBond; i--){
                    ans.add(matrix[i][leftBond]);
                }
                leftBond++;
            }
        }

        return ans;
    }


    // public List<Integer> spiralOrder(int[][] matrix) {
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     List<Integer> results = new ArrayList<>();
    //     boolean[][] visited = new boolean[row][col];
    //     int i=0;
    //     int j=0;
    //     results.add(matrix[i][j]);
    //     visited[i][j] = true;
    //     while (true){
    //         while (j<col-1 && !visited[i][j+1]){
    //             j++;
    //             results.add(matrix[i][j]);
    //             visited[i][j] = true;
    //         }
    //         if (i==row-1 || visited[i+1][j]){
    //             break;
    //         }
    //         while (i<row-1 && !visited[i+1][j]){
    //             i++;
    //             results.add(matrix[i][j]);
    //             visited[i][j] = true;
    //         }
    //         if (j==0 || visited[i][j-1]){
    //             break;
    //         }
    //         while (j>0 && ! visited[i][j-1]){
    //             j--;
    //             results.add(matrix[i][j]);
    //             visited[i][j] = true;
    //         }
    //         if (i==0 || visited[i-1][j]){
    //             break;
    //         }
    //         while (i>0 && ! visited[i-1][j]){
    //             i--;
    //             results.add(matrix[i][j]);
    //             visited[i][j] = true;
    //         }
    //         if (j==col-1 || visited[i][j+1]){
    //             break;
    //         }
    //     }
    //     return results;
    // }
}
