import java.util.Arrays;

public class Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // greedy, O(n log n)
        if (intervals.length<=1){
            return 0;
        }
        Arrays.sort(intervals, (e1, e2)->e1[1]-e2[1]);
        int ans = 1;
        int right = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0] >= right){
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
        
        // dp, O(n^2), time exceed

        // Arrays.sort(intervals, (e1, e2)->{
        //     if (e1[0] == e2[0]){
        //         return e1[1]-e2[1];
        //     } else {
        //         return e1[0]-e2[0];
        //     }
        // });
        // int ans = 1;
        // // use dp to record the max valid intervals
        // int[] dp = new int[intervals.length];
        // Arrays.fill(dp, 1);
        // for (int i=1; i<dp.length; i++){
        //     for (int j=0; j<i; j++){
        //         if (intervals[i][0]>=intervals[j][1]){
        //             dp[i] = Math.max(dp[i], dp[j]+1);
        //         }
        //     }
        //     ans = Math.max(ans, dp[i]);
        // }
        // return intervals.length-ans;
    }
}
