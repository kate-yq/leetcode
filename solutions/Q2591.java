import java.util.HashMap;

public class Q2591 {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0){
            return false;
        }
        int n = grid.length;

        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                map.put(grid[i][j], new int[] {i, j});
            }
        }

        int[] prev = map.get(0);
        for (int k = 1; k < n*n; k++){
            int[] cur = map.get(k);
            if (!valid(cur, prev)){
                return false;
            }
            prev = cur;
        }
        return true;
    }

    private boolean valid(int[] prev, int[] cur){
        if (Math.abs(prev[0]-cur[0]) == 2 && Math.abs(prev[1]-cur[1])==1){
            return true;
        }
        if (Math.abs(prev[0]-cur[0]) == 1 && Math.abs(prev[1]-cur[1])==2){
            return true;
        }
        return false;
    }
}
