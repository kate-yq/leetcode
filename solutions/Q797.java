import java.util.ArrayList;
import java.util.List;

public class Q797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        dfs(0, graph.length-1, visited, graph, result, new ArrayList<Integer>());
        return result;
    }

    private void dfs(int start, int end, 
                        boolean[] visited, 
                        int[][] graph, 
                        List<List<Integer>> result,
                        List<Integer> temp){
        if (start == end){
            ArrayList<Integer> copy = new ArrayList<>(temp);
            copy.add(end);
            result.add(copy);
            return;
        }
        if (visited[start]){
            return;
        }
        visited[start] = true;
        temp.add(start);
        for (int next : graph[start]){
            dfs(next, end, visited, graph, result, temp);
        }
        temp.remove(temp.size()-1);
        visited[start] = false;
    }
}
