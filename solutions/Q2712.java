public class Q2712 {
    public long minimumCost(String s) {
        long ans = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                ans += Math.min(i + 1, n - i - 1);
            }
        }

        return ans;
    }
}
