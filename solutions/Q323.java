public class Q323 {
    int[] parents;
    int count;

    public int countComponents(int n, int[][] edges) {
        this.parents = new int[n];
        this.count = n;

        for (int i=0; i<n; i++){
            parents[i] = i;
        }

        for (int[] edge : edges){
            int p1 = find(edge[0]);
            int p2 = find(edge[1]);
            if (p1 != p2){
                parents[p1] = parents[p2];
                count--;
            }
        }

        return count;
    }

    private int find(int cur){
        while(parents[cur] != cur){
            parents[cur] = find(parents[cur]);
            cur = parents[cur];
        }

        return parents[cur];
    }
}
