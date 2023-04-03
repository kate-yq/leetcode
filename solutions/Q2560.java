class Q2560 {
    public int minCapability(int[] nums, int k) {
        // binary search for the result
        // as nums[i]<= 10^9
        // search for a result and then see if this result is possible

        int left = 1;
        int right = (int) Math.pow(10, 9);
        int n = nums.length;

        // if determined a result, take the nums[i] when it <= result
        // then i+2 to skip the next one
        // check if there are k or more could be taken

        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; ++i){
                if (nums[i] <= mid) {
                    take += 1;
                    i++;
                }
            }
            
            if (take >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; //left == right
    }
}