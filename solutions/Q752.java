import java.util.*;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        HashSet<String> visited = new HashSet<>();
        for (String d : deadends) {
            visited.add(d);
        }

        if (visited.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                for (String next : generate(cur)) {
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                    if (next.equals(target)) {
                        return step;
                    }
                }
            }
        }

        return -1;
    }

    private List<String> generate(String s) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder(s);
            if (s.charAt(i) == '0') {
                sb.setCharAt(i, '9');
                ans.add(sb.toString());
            } else {
                sb.setCharAt(i, (char) (s.charAt(i) - 1));
                ans.add(sb.toString());
            }

            if (s.charAt(i) == '9') {
                sb.setCharAt(i, '0');
                ans.add(sb.toString());
            } else {
                sb.setCharAt(i, (char) (s.charAt(i) + 1));
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}
