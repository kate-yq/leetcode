import java.util.*;

public class Q1584 {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        for (int i=0; i<points.length; i++){
            for (int j=i+1; j<points.length; j++){
                int val = Math.abs(points[i][0] - points[j][0]) +  Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, val});
            }
        }

        Collections.sort(edges, (a,b)->a[2]-b[2]);

        UF uf = new UF(points.length);
        int weight = 0;

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (uf.isConnected(u, v)){
                continue;
            }
            weight += edge[2];
            uf.union(u, v);
        }

        return weight;
    }

    private class UF{
        int[] parents;

        private UF(int n){
            this.parents = new int[n];
            for (int i=0; i<n; i++){
                parents[i] = i;
            }
        }

        private boolean isConnected(int u, int v){
            return find(u) == find(v);
        }

        private void union(int u, int v){
            int p1 = find(u);
            int p2 = find(v);
            if (p1 != p2){
                parents[p1] = p2;
            }
        }

        private int find(int cur){
            if (parents[cur] != cur){
                parents[cur] = find(parents[cur]);
            }
            return parents[cur];
        }
    }
}
