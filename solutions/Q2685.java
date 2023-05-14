public class Q2685 {
    int[] unionNum = new int[50];
    int[] unionVertex = new int[50];
    int[] unionEdge = new int[50];

    public int countCompleteComponents(int n, int[][] edges) {
        // union find + degree check

        for (int i=0; i<n; i++){
            unionNum[i] = i;
            unionVertex[i] = 1;
            unionEdge[i] = 0;
        }

        for (int[] edge : edges){
            int union1 = get(edge[0]);
            int union2 = get(edge[1]);
            if (union1 != union2){
                unionVertex[union1] += unionVertex[union2];
                unionVertex[union2] = unionVertex[union1];
                unionNum[union1] = unionNum[union2];
            }
        }

        for (int[] edge : edges){
            unionEdge[get(edge[0])]++;
        }

        int ans = 0;

        for (int i=0; i<n; i++){
            if (unionNum[i] == i && unionEdge[i]*2 == unionVertex[i]*(unionVertex[i]-1)){
                ans++;
            }
        }

        return ans;
    }

    private int get(int x){
        if (unionNum[x] != x){
            unionNum[x] = get(unionNum[x]);
        }
        
        return unionNum[x];
    }
}
