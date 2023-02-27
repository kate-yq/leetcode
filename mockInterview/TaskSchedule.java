import java.util.HashMap;

public class TaskSchedule {
    long INF = Long.MAX_VALUE / 10;
    int n;
    int[] costs;
    int[] time;
    HashMap<Integer, Long>[] memo;

    public int minCost(int[] costs, int[] time){
        if (costs.length == 1){
            return costs[0];
        }
        this.costs = costs;
        this.n = costs.length;
        this.memo = new HashMap[n];

        for (int i=0; i<n; i++){
            memo[i] = new HashMap<>();
        } 
        return (int) dfs(0, 0);
    }

    private long dfs(int i, int timeSoFar){
        if (i == n){
            return timeSoFar>=0? 0: INF;
        }
        if (timeSoFar >= n-1) {
            return 0;
        }
        if (memo[i].containsKey(timeSoFar)){
            return memo[i].get(timeSoFar);
        }
        long resPaid = costs[i] + dfs(i+1, timeSoFar+time[i]);
        long resFree = dfs(i+1, timeSoFar-1);
        memo[i].put(timeSoFar, Math.min(resFree, resPaid));
        return memo[i].get(timeSoFar);
    }

    public static void main(String[] args){
        int[] costs = new int[]{1,1,2,3};
        int[] time = new int[]{3,1,2,3};
        TaskSchedule mc = new TaskSchedule();
        System.out.println(mc.minCost(costs, time));
    }
}
