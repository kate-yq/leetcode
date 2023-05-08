class Q303 {
    int[] preSum;

    public Q303(int[] nums) {
        this.preSum = new int[nums.length+1];
        for (int i=0; i<nums.length; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right+1]-preSum[left];
    }
}