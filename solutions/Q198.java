public class Q198 {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]);
            for (int j = 2; j<4 && j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j]+nums[i]);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        Q198 rob = new Q198();
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
