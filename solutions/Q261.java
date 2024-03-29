public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (uf.isConnected(u, v)){
                return false;
            }
            uf.union(u, v);
        }

        return uf.component() == 1;
    }

    private class UF{
        int[] parents;
        int count;

        private UF(int n){
            this.parents = new int[n];
            this.count = n;

            for (int i=0; i<n; i++){
                parents[i] = i;
            }
        }

        private boolean isConnected(int u, int v){
            return find(u)==find(v);
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
            if (parents[cur] != cur){
                parents[cur] = find(parents[cur]);
            }

            return parents[cur];
        }
    }
}
