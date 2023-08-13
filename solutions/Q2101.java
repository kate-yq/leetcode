import java.util.HashSet;
import java.util.Set;

public class Q2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        // 1. record the bombs that can be affected by each bomb
        Set<Integer>[] neighbors = new Set[n];

        for (int i = 0; i < n; i++) {
            neighbors[i] = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i != j && canAffect(bombs, i, j)) {
                    neighbors[i].add(j);
                }
            }
        }

        // 2. use a dfs to set up each bomb to get maximum amount
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, neighbors, new HashSet<>()));
        }
        return res;
    }

    // helper function to see if bomb i can affect bomb j
    private boolean canAffect(int[][] bombs, int i, int j) {
        double dis = Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2);
        return dis <= Math.pow(bombs[i][2], 2);
    }

    // dfs each bomb to see how many bombs can be set up
    private int dfs(int cur, Set<Integer>[] neighbors, Set<Integer> visited) {
        if (visited.contains(cur)) {
            return 0;
        }
        visited.add(cur);
        for (int next : neighbors[cur]) {
            dfs(next, neighbors, visited);
        }
        return visited.size();
    }
}
