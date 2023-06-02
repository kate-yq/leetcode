import java.util.*;

public class Q886 {
    int[] groups;
    HashMap<Integer, List<Integer>> graph;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.groups = new int[n+1];
        this.graph = new HashMap<>();

        for (int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] d : dislikes){
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        for (int i=1; i<=n; i++){
            if (groups[i] == 0){
                if (!dfs(i, 1)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int cur, int group){
        if (groups[cur] == group){
            return true;
        } else if (groups[cur] != 0){
            return false;
        }

        groups[cur] = group;

        for (int next : graph.get(cur)){
            if (!dfs(next, 0-group)){
                return false;
            }
        }

        return true;
    }
}
