import java.util.HashMap;
import java.util.HashSet;

public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        if (edges.length < n - 1) {
            return false;
        }

        // null means left over, false means loop, all true meand valid
        Boolean[] checked = new Boolean[n];
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        dfs(0, 0, checked, graph);

        for (Boolean check : checked) {
            if (check == null || !check) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int last, int cur, Boolean[] checked, HashMap<Integer, HashSet<Integer>> graph) {
        checked[cur] = true;
        for (int next : graph.get(cur)) {
            if (checked[next] != null) {
                if (next == last){
                    continue;
                }
                checked[next] = false;
            } else {
                dfs(cur, next, checked, graph);
            }
        }
    }
}
