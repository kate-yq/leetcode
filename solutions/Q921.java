public class Q921 {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right++;
            } else {
                right--;
                if (right == -1) {
                    left++;
                    right = 0;
                }
            }
        }

        return left + right;
    }
}
