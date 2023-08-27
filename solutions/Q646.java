import java.util.Arrays;

public class Q646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int[] memo = new int[2001];
        int n = pairs.length;

        int index = 0;
        for (int i = 1; i <= 2000; i++) {
            memo[i] = Math.max(memo[i], memo[i - 1]);
            while (index < n && pairs[index][1] + 1000 == i) {
                int left = pairs[index][0] + 1000;
                if (left == 0) {
                    memo[i] = Math.max(memo[i], 1);
                } else {
                    memo[i] = Math.max(memo[i], memo[left - 1] + 1);
                }
                index++;
            }
        }

        return memo[2000];
    }
}
