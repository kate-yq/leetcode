import java.util.*;

public class Q2781 {
    public static int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>(forbidden);

        int n = word.length();
        int[] maxi = new int[n];
        Arrays.fill(maxi, n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + 10 && j <= n; j++) {
                if (set.contains(word.substring(i, j))) {
                    maxi[i] = j - 1;
                    break;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            maxi[i] = Math.min(maxi[i], maxi[i + 1]);
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, maxi[i] - i);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println(longestValidSubstring("aaaabaaacc", Arrays.asList("bcca", "aaa", "aabaa", "baaac")));
    }
}
