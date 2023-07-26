import java.util.*;

public class Q1136 {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n + 1];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] relation : relations) {
            indegree[relation[1]]++;
            graph.putIfAbsent(relation[0], new ArrayList<>());
            graph.get(relation[0]).add(relation[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int sem = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (!graph.containsKey(cur)) {
                    continue;
                }
                for (int nextCourse : graph.get(cur)) {
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0) {
                        q.add(nextCourse);
                    }
                }
            }
            sem++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] != 0) {
                return -1;
            }
        }
        return sem;
    }
}
