import java.util.*;

public class Q2713 {

    public int maxIncreasingCells(int[][] mat) {
        List<int[]> nums = new ArrayList<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                nums.add(new int[] { mat[i][j], i, j });
            }
        }

        Collections.sort(nums, (a, b) -> a[0] - b[0]);

        int n = nums.size();
        int[] dp = new int[n];
        Map<Integer, Integer> maxRow = new HashMap<>();
        Map<Integer, Integer> maxCol = new HashMap<>();

        int startIdx = 0;
        for (int i = 0; i < n; ++i) {
            if (nums.get(i)[0] != nums.get(startIdx)[0]) {
                for (int j = startIdx; j < i; j++) {
                    maxRow.put(nums.get(j)[1], Math.max(maxRow.getOrDefault(nums.get(j)[1], 0), dp[j]));
                    maxCol.put(nums.get(j)[2], Math.max(maxCol.getOrDefault(nums.get(j)[2], 0), dp[j]));
                }
                startIdx = i;
            }
            dp[i] = Math.max(maxRow.getOrDefault(nums.get(i)[1], 0) + 1, maxCol.getOrDefault(nums.get(i)[2], 0) + 1);
        }

        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }
}
