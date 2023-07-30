import java.util.HashMap;
import java.util.HashSet;

public class Q2799 {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int size = set.size();
        int n = nums.length;
        int l = 0;
        int r = 0;

        int ans = 0;

        while (l < n && r <= n) {
            while (freq.size() < size && r < n) {
                freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
                r++;
            }
            if (freq.size() == size) {
                ans += (n + 1 - r);
            }

            if (freq.get(nums[l]) == 1) {
                freq.remove(nums[l]);
            } else {
                freq.put(nums[l], freq.get(nums[l]) - 1);
            }
            l++;
        }

        return ans;
    }
}
