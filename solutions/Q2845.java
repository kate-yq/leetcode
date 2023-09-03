import java.util.*;

public class Q2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long ans = 0;

        HashMap<Integer, Long> prefix = new HashMap<>();

        int count = 0;
        prefix.put(0, 1l);

        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                count++;
                count %= modulo;
            }
            ans += prefix.getOrDefault((count + modulo - k) % modulo, 0l);

            prefix.put(count, prefix.getOrDefault(count, 0l) + 1);
        }

        return ans;
    }
}
