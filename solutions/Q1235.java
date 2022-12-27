import java.util.Arrays;

class Q1235 {
    int[] memo;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        this.memo = new int[n];
        Arrays.fill(memo, -1);

        int[][] jobs = new int[n][3];
        for (int i=0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a,b)->{
            if (a[0] != b[0]){
                return a[0] - b[0];
            }
            if (a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
        }
        
        return findMaxProfit(jobs, startTime, n, 0);
    }

    private int findMaxProfit(int[][] jobs, int[] startTime, int n, int cur){
        // 0 profit if we have already iterated over all the jobs
        if (cur == n) {
            return 0;
        }
        
        // return result directly if it's calculated 
        if (memo[cur] != -1) {
            return memo[cur];
        }
        
        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs[cur][1]);
        
        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, cur + 1), 
                        jobs[cur][2] + findMaxProfit(jobs, startTime, n, nextIndex));
        
        // return maximum profit and also store it for future reference (memoization)
        memo[cur] = maxProfit;
        return maxProfit;
    }

    private int findNextJob(int[] startTime, int cur_end_time){
        int start = 0;
        int end = startTime.length - 1;
        int nextIndex = startTime.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= cur_end_time) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
}