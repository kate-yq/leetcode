public class Q785 {
    int[] colors;

    public boolean isBipartite(int[][] graph) {
        this.colors = new int[graph.length];
        
        for (int i=0; i<graph.length; i++){
            if (colors[i] == 0){
                if (!dfs(i, 1, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int cur, int color, int[][] graph){
        if (colors[cur] == color){
            return true;
        } else if (colors[cur] != 0){
            return false;
        }

        colors[cur] = color;

        for (int next : graph[cur]){
            if (!dfs(next, 0-color, graph)){
                return false;
            }
        }

        return true;
    }
}
