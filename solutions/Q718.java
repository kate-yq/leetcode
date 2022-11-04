public class Q718 {
    public int findLength(int[] nums1, int[] nums2) {
        // int[i][j] to store the len of common subarray stops at nums1[i-1] and
        // nums2[j-1]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int max_len = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max_len = Math.max(max_len, dp[i][j]);
                }
            }
        }
        return max_len;
    }
}
