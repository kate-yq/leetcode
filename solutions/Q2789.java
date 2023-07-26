public class Q2789 {
    public long maxArrayValue(int[] nums) {

        int lastMaxIn = nums.length - 1;
        long ans = nums[lastMaxIn];
        long prev = nums[lastMaxIn];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= prev) {
                prev += nums[i];
            } else {
                lastMaxIn = i;
                prev = nums[i];
            }
            ans = Math.max(ans, prev);
        }

        return ans;
    }
}
