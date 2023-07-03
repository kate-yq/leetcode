public class Q2697 {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) < s.charAt(r)) {
                sb.setCharAt(r, s.charAt(l));
            } else if (s.charAt(l) > s.charAt(r)) {
                sb.setCharAt(l, s.charAt(r));
            }
            l++;
            r--;
        }

        return sb.toString();
    }
}
