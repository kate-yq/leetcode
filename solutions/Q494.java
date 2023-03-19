class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        // devide the arr into 2 sub arr
        // one with all add elements, and one with all subtract elements
        // call it a and b
        // then we know that sum(a) + sum(b) = sum(nums)
        // sum(a) - sum(b) = target
        // therefore, sum(a) = (sum(nums) + target)/2
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        // impossible case
        if (sum < Math.abs(target) || (sum + target)%2 != 0){
            return 0;
        }

        // find how many subarr there are, so that the sum is (sum + target)/2
        int n = nums.length;
        int aSum = (sum + target)/2;
        int[][] dp = new int[n+1][aSum+1];
        dp[0][0] = 1;
        for (int i=1; i<=n; i++){
            for (int j=0; j<=aSum; j++){
                if (j >= nums[i-1]){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[n][aSum];
    }
}