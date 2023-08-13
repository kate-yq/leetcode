import java.util.List;

public class Q2811 {
    Boolean[][] memo;

    public boolean canSplitArray(List<Integer> nums, int m) {
        int sum = nums.stream().reduce(0, (a, b) -> a + b);
        int n = nums.size();
        if (n <= 2) {
            return true;
        }

        this.memo = new Boolean[n][n];
        return check(nums, m, sum, 0, n - 1);
    }

    private boolean check(List<Integer> nums, int m, int sum, int start, int end) {
        if (start == end) {
            return true;
        }
        if (sum < m) {
            return false;
        }

        if (memo[start][end] != null) {
            return memo[start][end];
        }

        memo[start][end] = check(nums, m, sum - nums.get(start), start + 1, end);
        memo[start][end] |= check(nums, m, sum - nums.get(end), start, end - 1);

        return memo[start][end];
    }
}
