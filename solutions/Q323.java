import java.util.HashMap;
import java.util.HashSet;

public class Q323 {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++){
            graph.put(i, new HashSet<>());
        }
        for (int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int part = 0;
        Integer[] component = new Integer[n];
        for (int i=0; i<n; i++){
            part = bfs(i, part, component, graph);
        }
        return part;
    }

    private int bfs(int vertex, int cur_part, Integer[] component, HashMap<Integer, HashSet<Integer>> graph){
        if (component[vertex] != null){
            return cur_part;
        }
        component[vertex] = cur_part;
        for (int next: graph.get(vertex)){
            bfs(next, cur_part, component, graph);
        }

        return ++cur_part;
    }
}
