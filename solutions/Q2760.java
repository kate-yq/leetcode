public class Q2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                nums[i] = -1;
            } else {
                nums[i] %= 2;
            }
        }

        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {

                int cur = 1;
                while (index < nums.length - 1 && nums[index] + nums[index + 1] == 1) {
                    index++;
                    cur++;
                }
                max = Math.max(max, cur);
            }
            index++;
        }

        return max;
    }
}
