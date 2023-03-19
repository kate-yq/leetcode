import java.util.*;

public class Q787dp {
    HashMap<Integer, List<int[]>> indegree;
    int[][] memo;
    int src, dst;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        this.src = src;
        this.dst = dst;
        this.memo = new int[n][k+1];
        for(int[] row : memo){
            Arrays.fill(row, -10);
        }

        this.indegree = new HashMap<>();
        for (int[] flight : flights){
            if (!indegree.containsKey(flight[1])){
                indegree.put(flight[1], new ArrayList<>());
            }
            indegree.get(flight[1]).add(new int[]{flight[0], flight[2]});
        }
        return dp(dst, k);
    }

    private int dp(int cur, int remaingK){
        if (cur == src){
            return 0;
        }
        if (remaingK < 0){
            return -1;
        }
        if (memo[cur][remaingK] != -10){
            return memo[cur][remaingK];
        }
        
        if (!indegree.containsKey(cur)){
            memo[cur][remaingK] = -1;
            return memo[cur][remaingK];
        }
        
        int res = Integer.MAX_VALUE;
        for (int[] flight : indegree.get(cur)){
            int next = dp(flight[0], remaingK-1);
            if (next != -1){
                res = Math.min(res, dp(flight[0], remaingK-1)+flight[1]);
            }
        }
        memo[cur][remaingK] = res==Integer.MAX_VALUE? -1:res;
        return memo[cur][remaingK];
    }
}
