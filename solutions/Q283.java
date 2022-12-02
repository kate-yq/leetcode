class Q283 {
    public void moveZeroes(int[] nums) {
        int end = 0;
        int right = 0;
        for (int left=0; left<nums.length & right<nums.length; left++){
            while (nums[right]==0 & right<nums.length-1){
                right++;
            }
            nums[left] = nums[right];
            right++;
            end = left+1;
        }
        for (int i=end; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}