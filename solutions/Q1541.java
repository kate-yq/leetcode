public class Q1541 {
    public int minInsertions(String s) {
        int left = 0;
        int right = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right += 2;
                if (right % 2 == 1) {
                    right--;
                    ans++;
                }
            } else {
                right--;
                if (right == -1) {
                    left++;
                    right = 1;
                }
            }
        }

        return left + right + ans;
    }
}
