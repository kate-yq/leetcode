import java.util.*;

public class Q1631 {
    // public int minimumEffortPath(int[][] heights) {
    //     int m = heights.length;
    //     int n = heights[0].length;

    //     HashMap<Integer, List<int[]>> graph = new HashMap<>();
    //     for (int i=0; i<m; i++){
    //         for (int j=0; j<n; j++){
    //             graph.put(i*n + j, new ArrayList<>());
    //             if (i>0){
    //                 graph.get(i*n + j).add(new int[]{i-1, j, Math.abs(heights[i][j] - heights[i-1][j])});
    //             }
    //             if (i<m-1){
    //                 graph.get(i*n + j).add(new int[]{i+1, j, Math.abs(heights[i][j] - heights[i+1][j])});
    //             }
    //             if (j>0){
    //                 graph.get(i*n + j).add(new int[]{i, j-1, Math.abs(heights[i][j] - heights[i][j-1])});
    //             }
    //             if (j<n-1){
    //                 graph.get(i*n + j).add(new int[]{i, j+1, Math.abs(heights[i][j] - heights[i][j+1])});
    //             }
    //         }
    //     }

    //     int[][] effortFromStart = new int[m][n];
    //     for (int[] e : effortFromStart){
    //         Arrays.fill(e, Integer.MAX_VALUE);
    //     }

    //     effortFromStart[0][0] = 0;

    //     PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> a.effortFromStart - b.effortFromStart);
    //     pq.add(new State(0, 0, 0));

    //     while(!pq.isEmpty()){
    //         State cur = pq.poll();

    //         if (cur.row == m-1 && cur.col == n-1){
    //             return cur.effortFromStart;
    //         }
    //         if (cur.effortFromStart > effortFromStart[cur.row][cur.col]){
    //             continue;
    //         }
    //         for (int[] next : graph.get(cur.row * n + cur.col)){
    //             int nextEffort = Math.max(next[2], effortFromStart[cur.row][cur.col]);
    //             if (nextEffort < effortFromStart[next[0]][next[1]]){
    //                 effortFromStart[next[0]][next[1]] = nextEffort;
    //                 pq.add(new State(next[0], next[1], nextEffort));
    //             }
    //         }
    //     }

    //     return -1;

    // }

    int m, n;

    public int minimumEffortPath(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;

        int[][] effortFromStart = new int[m][n];
        for (int[] e : effortFromStart){
            Arrays.fill(e, Integer.MAX_VALUE);
        }

        effortFromStart[0][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> a.effortFromStart - b.effortFromStart);
        pq.add(new State(0, 0, 0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curR = cur.row;
            int curC = cur.col;

            if (curR == m-1 && curC == n-1){
                return cur.effortFromStart;
            }
            if (cur.effortFromStart > effortFromStart[curR][curC]){
                continue;
            }
            for (int[] next : adj(curR, curC)){
                int nextR = next[0];
                int nextC = next[1];
                int nextEffort = Math.max(
                    Math.abs(heights[curR][curC]-heights[nextR][nextC]), 
                    effortFromStart[curR][curC]
                    );
                if (nextEffort < effortFromStart[nextR][nextC]){
                    effortFromStart[nextR][nextC] = nextEffort;
                    pq.add(new State(nextR, nextC, nextEffort));
                }
            }
        }

        return -1;
    }

    private List<int[]> adj(int row, int col){
        List<int[]> neighbors = new ArrayList<>();
        if (row > 0){
            neighbors.add(new int[]{row-1, col});
        }
        if (row < m-1){
            neighbors.add(new int[]{row+1, col});
        }
        if (col > 0){
            neighbors.add(new int[]{row, col-1});
        }
        if (col < n-1){
            neighbors.add(new int[]{row, col+1});
        }
        return neighbors;
    }

    class State{
        int row;
        int col;
        int effortFromStart;

        private State(int row, int col, int effortFromStart){
            this.row = row;
            this.col = col;
            this.effortFromStart = effortFromStart;
        }
    }
}
