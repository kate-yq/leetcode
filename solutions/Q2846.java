import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2846 {

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], k = edge[2] - 1;
            adj[u].add(new int[] { v, k });
            adj[v].add(new int[] { u, k });
        }

        // bfs
        // treat 0 as root
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int[][] jump = new int[n][20];
        int[][] count = new int[n][26];
        int[] depth = new int[n];

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] edge : adj[u]) {
                int v = edge[0], weight = edge[1];

                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                    depth[v] = depth[u] + 1;
                    jump[v][0] = u;
                    for (int j = 0; j < 26; j++) {
                        count[v][j] = count[u][j];
                    }
                    count[v][weight]++;
                }
            }
        }

        // The reason for using "20" in this context is to ensure that the code can
        // efficiently compute the jump values for LCA for nodes in a tree with a
        // maximum depth of 20 levels.
        // It's a common technique to use a value that's guaranteed to be larger than
        // the depth of the tree to avoid potential issues with the code, even if the
        // tree is smaller.
        // In many cases, this depth value is chosen based on the expected tree size
        // and structure to strike a balance between efficiency and simplicity.

        for (int j = 1; j < 20; j++) {
            for (int i = 0; i < n; i++) {
                jump[i][j] = jump[i][j - 1] == -1 ? -1 : jump[jump[i][j - 1]][j - 1];
            }
        }

        // generate answer

        int[] res = new int[queries.length];
        int cur = 0;

        for (int[] query : queries) {
            int u = query[0], v = query[1];
            int u2 = u, v2 = v;
            // to go up and make them at the same depth
            for (int j = 19; j >= 0; j--) {
                if (jump[u2][j] >= 0 && depth[jump[u2][j]] >= depth[v2]) {
                    u2 = jump[u2][j];
                }
                if (jump[v2][j] >= 0 && depth[jump[v2][j]] >= depth[u2]) {
                    v2 = jump[v2][j];
                }
            }

            // find the LCA
            for (int j = 19; j >= 0; j--) {
                if (jump[u2][j] != jump[v2][j]) {
                    u2 = jump[u2][j];
                    v2 = jump[v2][j];
                }
            }

            int lca = u2 == v2 ? u2 : jump[u2][0];

            int operation = Integer.MAX_VALUE;
            for (int k = 0; k < 26; k++) {
                int cnt = count[u][k] + count[v][k] - 2 * count[lca][k];
                operation = Math.min(operation, depth[u] + depth[v] - 2 * depth[lca] - cnt);
            }
            res[cur++] = operation;
        }
        return res;
    }
}
