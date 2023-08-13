import java.util.*;

class Q2815 {
    public int maxSum(int[] nums) {

        Map<Integer, List<Integer>> maxDigits = new HashMap<>();

        int max = -1;

        for (int n : nums) {
            int maxD = calculateMaxDigits(n);

            maxDigits.putIfAbsent(maxD, new ArrayList<>());
            maxDigits.get(maxD).add(n);
        }

        for (int key : maxDigits.keySet()) {
            List<Integer> cur = maxDigits.get(key);
            Collections.sort(cur, (a, b) -> b - a);
            if (cur.size() >= 2) {
                max = Math.max(max, cur.get(0) + cur.get(1));
            }
        }

        return max;
    }

    private int calculateMaxDigits(int n) {
        int max = 0;
        while (n > 0) {
            max = Math.max(max, n % 10);
            n /= 10;
        }
        return max;
    }
}