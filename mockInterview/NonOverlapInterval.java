import java.util.PriorityQueue;

public class NonOverlapInterval {
    public long get3NOI(int[] starts, int[] ends){
        int n = starts.length;
        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        for (int i=0; i<n; i++){
            minheap.add(new int[]{starts[i], ends[i]});
        }

        // record the total non-overlaping intervals before it
        // start, end, #
        int[][] dp = new int[n][3];
        for (int i=0; i<n; i++){
            int[] cur = minheap.poll();
            dp[i][0] = cur[0];
            dp[i][1] = cur[1];
            for (int j=i-1; j>=0; j--){
                if (dp[j][1] < dp[i][0]){
                    dp[i][2] = j+1;
                    break;
                }
            }
        }

        long sum = 0;
        for (int i=2; i<n; i++){
            for (int j=i-1; j>0; j--){
                if (dp[j][1] < dp[i][0]){
                    sum += dp[j][2];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args){
        int[] start = {1,2,4,3,7};
        int[] end = {3,4,6,5,8};
        NonOverlapInterval gn = new NonOverlapInterval();
        System.out.println(gn.get3NOI(start, end));
    }
}
