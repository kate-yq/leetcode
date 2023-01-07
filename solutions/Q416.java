public class Q416 {
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        if (nums.length == 1){
            return false;
        }
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        if (sum%2!=0) {
            return false;
        }
        this.memo = new Boolean[nums.length+1][sum/2+1];
        return canfindsum(nums, 0, sum/2);
    }

    private boolean canfindsum(int[] nums, int start, int sum){
        if (sum < 0 || start>=nums.length){
            return false;
        }
        if (sum == 0){
            memo[start][sum] = true;
            return true;
        }

        if(memo[start+1][sum]==null){
            memo[start][sum] = canfindsum(nums, start+1, sum);
        } else if (memo[start+1][sum]==false){
            memo[start][sum] = false;
        } else {
            memo[start][sum] = true;
            return true;
        }
        if (sum-nums[start]>=0){
            if (memo[start+1][sum-nums[start]]==null){
                memo[start][sum] = memo[start][sum] || canfindsum(nums, start+1, sum-nums[start]);
            } else if (memo[start+1][sum-nums[start]]==true){
                memo[start][sum] = true;
                return true;
            }
        }
        return memo[start][sum];
    }
}
