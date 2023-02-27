import java.util.PriorityQueue;

public class MaximumOrderVolume {
    public int maxVolume(int[] start, int[] duration, int[] volume){
        int n = start.length;
        // {start, end, cur-max-volume}
        int[][] dp = new int[n+1][3];
        PriorityQueue<int[]> calls = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        for (int i=0; i<n; i++){
            calls.add(new int[]{i, start[i], start[i]+duration[i]});
        }

        int max = 0;
        for (int i=1; i<n; i++){
            int[] cur = calls.poll();
            int id = cur[0];
            dp[i][0] = cur[1];
            dp[i][1] = cur[2];
            for (int j = 0; j < i; j++){
                if (dp[j][1] <= dp[i][0]){
                    dp[i][2] = Math.max(dp[i][2], dp[j][2]+volume[id]);
                }
            }
            max = Math.max(max, dp[i][2]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] start = {10, 5, 15, 18, 30};
        int[] duration = {30,12,20,35,35};
        int[] volume = {50,51,20,25,10};
        MaximumOrderVolume mv = new MaximumOrderVolume();
        System.out.println(mv.maxVolume(start, duration, volume));
    }
}
