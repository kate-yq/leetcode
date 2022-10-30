public class Q55 {
    public boolean canJump(int[] nums) {
        // go through once, time complexity O(n)
        int max_reach = nums[0];
        for (int i=1; i<nums.length && i<=max_reach; i++){
            max_reach = Math.max(i+nums[i], max_reach);
        }
        return max_reach >= nums.length-1;

        // another way using dp, but!!! time complexity O(n^2)
        // // dp represents whether can reach current index;
        // boolean[] dp = new boolean[nums.length];
        // dp[0] = true;
        // for (int i=1; i<dp.length; i++){
        //     for (int j =0; j<i; j++){
        //         if (dp[j] && nums[j]+j>=i){
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[dp.length-1];
    }
}
