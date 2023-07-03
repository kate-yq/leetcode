import java.util.*;

public class Q2762 {
    public long continuousSubarrays(int[] nums) {
        int left = 0;
        int right = 0;
        long count = 0;
        TreeMap<Integer, Integer> freq = new TreeMap<>();

        freq.put(nums[0], 1);
        while (right < nums.length) {
            int min = freq.firstKey();
            int max = freq.lastKey();

            if (Math.abs(max - min) <= 2 || left > right) {
                count += right - left + 1;
                right++;
                if (right < nums.length) {
                    freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
                }

            } else {
                if (freq.get(nums[left]) == 1) {
                    freq.remove(nums[left]);
                } else {
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                }
                left++;
            }
        }

        return count;
    }
}
