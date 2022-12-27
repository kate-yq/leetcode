public class Q994 {
    public int orangesRotting(int[][] grid) {
        int minute = 0;
        boolean fresh = false;
        boolean rotten = false;
        int cur = 2;
        while (true){
            // have to re-set the indicator each loop
            fresh = false;
            rotten = false;
            for (int i=0; i<grid.length; i++){
                for (int j=0; j<grid[0].length; j++){
                    if (grid[i][j] == cur){
                        // need to use or to keep the true value if there is any
                        rotten = expand(grid, i, j, cur+1) || rotten;
                    } else if (grid[i][j] == 1){
                        // if find a fresh, set indicator
                        fresh = true;
                    }
                }
            }
            if (rotten) {
                minute++;
                cur++;
            } else {
                break;
            }
        }
        if (fresh){
            return -1;
        }
        return minute;
    }

    private boolean expand(int[][] grid, int i, int j, int cur){
        boolean rot = false;
        if (i>0 && grid[i-1][j]==1){
            grid[i-1][j] = cur;
            rot = true;
        }
        if (i<grid.length-1 && grid[i+1][j]==1){
            grid[i+1][j] = cur;
            rot = true;
        }
        if (j>0 && grid[i][j-1]==1){
            grid[i][j-1] = cur;
            rot = true;
        }
        if (j<grid[0].length-1 && grid[i][j+1]==1){
            grid[i][j+1] = cur;
            rot = true;
        }
        return rot;
    }
}
