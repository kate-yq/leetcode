class Q2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int prevOut = -1;
        int prevMin = -1;
        int prevMax = -1;

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                prevOut = i;
            }
            if (nums[i] == minK) {
                prevMin = i;
            }
            if (nums[i] == maxK) {
                prevMax = i;
            }
            ans += Math.max(0, Math.min(prevMax, prevMin) - prevOut);
        }

        return ans;
    }
}