import java.util.*;

public class Q2646 {
    HashMap<Integer, HashSet<Integer>> graph;
    int[] hit;
    int[] prices;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        graph = new HashMap<>();
        hit = new int[n];
        this.prices = price;

        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        for(int[] t : trips) {
            List<Integer> trace = new ArrayList<>();
            dfs(t[0], -1, t[1], trace);
            for(int x : trace) {
                hit[x]++;
            }
        }

        int[] ans = dp(0, -1);
        return Math.min(ans[0], ans[1]);
    }


    public boolean dfs(int cur, int prev, int end, List<Integer> trace) {
        trace.add(cur);
        if(cur == end) {
            return true;
        }
        for(int next : graph.get(cur)) {
            if(next == prev) {
                continue;
            }
            if(dfs(next, cur, end, trace)) {
                return true;
            }
        }
        trace.remove(trace.size() - 1);
        return false;
    }
    

    public int[] dp(int cur, int prev) {
        // [no half for current, half for current]
        int[] ans = new int[] {hit[cur] * prices[cur], hit[cur] * (prices[cur] / 2)};

        for (int next : graph.get(cur)) {
            if (next == prev) {
                continue;
            }
            int[] sub = dp(next, cur);
            ans = new int[] {ans[0] + Math.min(sub[0], sub[1]), ans[1] + sub[0]};
        }
        return ans;
    }
}
