import java.util.Arrays;
import java.util.PriorityQueue;

class Q767 {
    public String reorganizeString(String s) {
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++) {
            count[i][0] = i;
        }

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index][1]++;
        }

        // impossible case: exist a major character
        for (int[] c : count) {
            if (c[1] > (s.length() + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> {
            if (b[1] == a[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        for (int[] c : count) {
            if (c[1] > 0) {
                maxheap.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (sb.length() < s.length()) {
            int[] top = maxheap.poll();
            sb.append((char) ('a' + top[0]));
            if (!maxheap.isEmpty()) {
                int[] second = maxheap.poll();
                sb.append((char) ('a' + second[0]));
                second[1]--;
                if (second[1] > 0) {
                    maxheap.offer(second);
                }
            }
            top[1]--;
            if (top[1] > 0) {
                maxheap.offer(top);
            }
        }

        return sb.toString();

    }

    public String reorganizeString2(String s) {
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++) {
            count[i][0] = i;
        }

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index][1]++;
        }

        char[] ans = new char[s.length()];
        Arrays.sort(count, (a, b) -> b[1] - a[1]);

        // impossible case: exist a major character
        if (count[0][1] > (s.length() + 1) / 2) {
            return "";
        }

        int index = 0;
        int i = 0;
        while (i < 26) {
            if (index >= ans.length) {
                index = 1;
            }
            if (count[i][1] == 0) {
                i++;
                continue;
            }
            ans[index] = (char) (count[i][0] + 'a');
            count[i][1]--;
            index += 2;
        }

        return String.valueOf(ans);
    }
}