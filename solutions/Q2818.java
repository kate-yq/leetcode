import java.util.*;

public class Q2818 {

    int mod = (int) Math.pow(10, 9) + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] scores = new int[n];

        // calculate prime score
        for (int i = 0; i < n; i++) {
            int cur = nums.get(i);
            for (int j = 2; j * j <= cur; j++) {
                if (cur % j == 0) {
                    scores[i]++;
                    while (cur % j == 0) {
                        cur /= j;
                    }
                }
            }
            if (cur != 1) {
                scores[i]++;
            }
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            maxheap.offer(new int[] { nums.get(i), i });
        }

        long ans = 1;
        int count = 0;
        while (count < k) {
            int[] max = maxheap.poll();
            int l = max[1] - 1;
            int r = max[1] + 1;
            while (l >= 0 && scores[l] < scores[max[1]]) {
                l--;
            }
            while (r < n && scores[r] <= scores[max[1]]) {
                r++;
            }

            int pow = (max[1] - l) * (r - max[1]);
            pow = Math.min(pow, k - count);
            count += pow;
            ans *= power(max[0], pow);
            ans %= mod;
        }

        return (int) ans;
    }

    private long power(long num, int pow) {
        long ans = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans = ans * num % mod;
            }
            num = num * num % mod;
            pow >>= 1;
        }

        return ans;
    }
}
