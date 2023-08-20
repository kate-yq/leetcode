import java.util.*;

public class Q2831 {
    int maxNum = -1;
    int maxFreq = 0;

    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int l = 0;
        int r = 0;
        int ans = 0;

        while (r < nums.size()) {
            int cur = nums.get(r);
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);

            if (freq.get(cur) > maxFreq) {
                maxFreq = freq.get(cur);
                maxNum = cur;
            }

            while (r - l + 1 - maxFreq > k) {
                int left = nums.get(l);
                freq.put(left, freq.get(left) - 1);

                if (left == maxNum && freq.get(maxNum) <= k) {
                    update(freq);
                }
                l++;
            }
            r++;

            ans = Math.max(ans, freq.get(maxNum));
        }

        return ans;
    }

    private void update(Map<Integer, Integer> freq) {
        for (int key : freq.keySet()) {
            if (freq.get(key) > maxFreq) {
                maxFreq = freq.get(key);
                maxNum = key;
            }
        }
    }
}
