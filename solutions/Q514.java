import java.util.ArrayList;
import java.util.HashMap;

class Q514 {
    HashMap<Character, ArrayList<Integer>> charToIndex;
    int m,n;
    int[][] memo;
    String ring;
    String key;

    public int findRotateSteps(String ring, String key) {
        this.m = ring.length();
        this.n = key.length();
        this.ring = ring;
        this.key = key;

        this.charToIndex = new HashMap<>();
        for (int i=0; i<m; i++){
            if (!charToIndex.containsKey(ring.charAt(i))){
                charToIndex.put(ring.charAt(i), new ArrayList<>());
            }
            charToIndex.get(ring.charAt(i)).add(i);
        }

        this.memo = new int[m][n];
        
        return find(0, 0);
    }

    private int find(int i, int j){
        if (j == n){
            return 0;
        }
        if (memo[i][j] != 0){
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;

        for (int k : charToIndex.get(key.charAt(j))){
            int distance = Math.abs(i - k);
            int mindis = Math.min(distance, m - distance);
            int prev = find(k, j+1);
            res = Math.min(res, 1+mindis+prev);
        }

        memo[i][j] = res;
        
        return res;
    }
}