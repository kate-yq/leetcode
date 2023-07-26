import java.util.*;

public class Q2791 {
    public long countPalindromePaths(List<Integer> parent, String s) {

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < parent.size(); i++) {
            graph.computeIfAbsent(parent.get(i), t -> new ArrayList<>()).add(i);
        }

        HashMap<Integer, Long> map = new HashMap<>();

        countPalindromePaths(0, 0, s, graph, map);

        long count = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            count += entry.getValue() * (entry.getValue() - 1);
            for (int i = 0; i < 26; i++) {
                count += entry.getValue() * map.getOrDefault(entry.getKey() ^ 1 << i, 0L);
            }
        }
        return count / 2;
    }

    private void countPalindromePaths(int v, int mask, String s, HashMap<Integer, ArrayList<Integer>> graph,
            HashMap<Integer, Long> map) {
        map.put(mask, map.getOrDefault(mask, 0L) + 1);
        for (int i : graph.getOrDefault(v, new ArrayList<>())) {
            countPalindromePaths(i, mask ^ 1 << s.charAt(i) - 'a', s, graph, map);
        }
    }

}
