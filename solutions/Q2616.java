import java.util.Arrays;

public class Q2616 {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;

        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0];
        
        Arrays.sort(nums);

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 0; i < n - 1; i++) {
                if (nums[i + 1] - nums[i] <= mid) {
                    count++;
                    i++;
                }
            }

            if (count >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
