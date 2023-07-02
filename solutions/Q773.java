import java.util.*;

public class Q773 {
    int[][] neighbor = {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 1, 3, 5 },
            { 2, 4 }
    };

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String target = "123450";

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int step = 0;
        q.offer(sb.toString());

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                visited.add(cur);
                for (String next : generate(cur)) {
                    if (!visited.contains(next)) {
                        q.offer(next);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private List<String> generate(String s) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        for (; s.charAt(idx) != '0'; idx++) {
        }

        for (int n : neighbor[idx]) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(n, '0');
            sb.setCharAt(idx, s.charAt(n));
            ans.add(sb.toString());
        }
        return ans;
    }
}
