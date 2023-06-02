import java.util.Arrays;

public class Q1135 {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a,b)-> a[2]-b[2]);

        int weight = 0;

        UF uf = new UF(n+1);

        for (int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            if (uf.isConnected(u, v)){
                continue;
            }
            weight += edge[2];
            uf.union(u, v);
            if (uf.component() == 2){
                return weight;
            }
        }

        return -1;
    }

    private class UF{
        int[] parents;
        int count;

        private UF(int n){
            this.parents = new int[n];
            this.count = n;

            for(int i=0; i<n; i++){
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
                count--;
            }
        }

        private int component(){
            return count;
        }

        private int find(int cur){
            if (parents[cur]!= cur){
                parents[cur] = find(parents[cur]);
                cur = parents[cur];
            }

            return parents[cur];
        }
    }
}
