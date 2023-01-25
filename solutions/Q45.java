// import java.util.Arrays;

class Q45 {
    public int jump(int[] nums) {
        // greedy

        // The starting range of the first jump is [0, 0]
        int answer = 0;
        int n = nums.length;
        int curEnd = 0;
        int curFar = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        
        return answer;

        // int[] counts = new int[nums.length];
        // Arrays.fill(counts, Integer.MAX_VALUE);
        // counts[0] = 0;
        // for (int i=0; i<nums.length;i++){
        //     int reach = i + nums[i];
        //     int cur = counts[i];
        //     for (int j=i+1; j<=reach && j<nums.length; j++){
        //         if (counts[j] > cur+1){
        //             counts[j] = cur+1;
        //         }
        //     }
        // }
        // return counts[counts.length-1];
    }
}