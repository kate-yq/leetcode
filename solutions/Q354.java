import java.util.Arrays;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        Arrays.sort(envelopes,(a, b)->{
            if (a[0] != b[0]){
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int max = 1;

        for (int i=0; i<n; i++){
            int val = envelopes[i][1];
            int index = binarySearch(dp, val);
            max = Math.max(max, index);
            if (dp[index] >= val){
                dp[index] = val;
            }
        }

        return max;
    }


    private int binarySearch(int[] dp, int val){
        int lo=0;
        int hi=dp.length-1;

        while(lo < hi-1){
            int mid=lo + (hi-lo)/2;
            if(dp[mid]<val){
                lo=mid + 1;
            }else{
                hi=mid;
            }
        }
        return dp[lo] >= val ? lo : hi;
    }
}
