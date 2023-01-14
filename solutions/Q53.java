class Q53 {
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int temp_sum = 0;
        int max_sum = nums[0]; // Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp_sum = temp_sum + nums[i];
            if (temp_sum > max_sum) {
                max_sum = temp_sum;
            }
            if (temp_sum < 0) {
                temp_sum = 0;
            }
        }
        return max_sum;
    }
}