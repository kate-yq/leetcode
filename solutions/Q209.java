public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 1000000;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return len == 1000000 ? 0 : len;
    }
}
