import java.util.*;

public class Q2707 {
    public int minExtraChar(String s, String[] dictionary) {
        List<int[]> matches = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (String d : dictionary) {
                if (i + d.length() <= s.length() && s.substring(i, i + d.length()).equals(d)) {
                    matches.add(new int[] { i + 1, i + d.length() });
                }
            }
        }

        Collections.sort(matches, (a, b) -> a[1] - b[1]);

        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, memo.length);

        memo[0] = 0;
        int index = 0;

        for (int i = 1; i < memo.length; i++) {
            memo[i] = Math.min(memo[i - 1] + 1, memo[i]);
            while (index < matches.size() && matches.get(index)[1] == i) {
                memo[i] = Math.min(memo[i], memo[matches.get(index)[0] - 1]);
                index++;
            }
        }

        return memo[s.length()];
    }
}
