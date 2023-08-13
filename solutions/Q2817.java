import java.util.List;
import java.util.TreeSet;

public class Q2817 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();

        int minDiff = Integer.MAX_VALUE;

        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));

            int cur = nums.get(i);
            if (set.contains(cur)) {
                return 0;
            }

            if (set.first() < cur) {
                int low = set.floor(cur);
                minDiff = Math.min(minDiff, Math.abs(low - cur));
            }

            if (set.last() > cur) {
                int high = set.higher(cur);
                minDiff = Math.min(minDiff, Math.abs(high - cur));
            }
        }

        return minDiff;
    }
}
