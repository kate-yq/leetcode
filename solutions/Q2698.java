public class Q2698 {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                ans += i * i;
            }
        }

        return ans;
    }

    private boolean check(int i) {
        String s = String.valueOf(i * i);
        return dfs(i, s, 0);
    }

    private boolean dfs(int remain, String s, int index) {
        if (remain < 0) {
            return false;
        }
        if (remain == 0 && index == s.length()) {
            return true;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            if (dfs(remain - Integer.parseInt(s.substring(index, i)), s, i)) {
                return true;
            }
        }

        return false;
    }
}
