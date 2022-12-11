import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Q1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination){
            return true;
        }
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> dfs = new Stack<>();
        dfs.add(source);
        while (!dfs.isEmpty()){
            int parent = dfs.pop();
            visited[parent] = true;
            for (int kid : graph.get(parent)){
                if (kid == destination){
                    return true;
                }
                if (!visited[kid]){
                    dfs.add(kid);
                }
            }
        }
        return false;
    }
}