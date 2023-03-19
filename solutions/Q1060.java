class Q1060 {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        // nums[i] - i - nums[0] = total number of missing num until current num
        // if total number = k, k num missing before current num
        
        // locate index a, so that nums[a] missing < k, nums[a+1] missing >=k
        // return nums[a]+k-missing

        int indexL = 0;

        while (l<r-1){
            int mid = l + (r-l)/2;
            if (nums[mid] - nums[0] - mid >= k){
                r = mid-1;
            } else if (nums[mid] - nums[0] - mid < k){
                l = mid;
            }
        }
        if (nums[r] - nums[0] - r < k){
            indexL = r;
        } else {
            indexL = l;
        }

        // return nums[indexL] + k - (nums[indexL] - nums[0] - indexL);
        return k + nums[0] + indexL;
    }
}