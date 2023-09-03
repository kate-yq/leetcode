import java.util.*;

public class Q443 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Integer> steps = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String b : bank) {
            int diff = calculateDiff(startGene, b);
            if (diff == 1) {
                steps.put(b, 1);
                queue.add(b);
            } else {
                steps.put(b, 100);
            }
        }

        if (!steps.containsKey(endGene)) {
            return -1;
        }

        if (steps.containsKey(startGene)) {
            steps.put(startGene, 0);
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String next : bank) {
                if (calculateDiff(next, cur) == 1 && steps.get(next) > steps.get(cur) + 1) {
                    steps.put(next, steps.get(cur) + 1);
                    queue.add(next);
                }
            }
        }

        return steps.get(endGene) == 100 ? -1 : steps.get(endGene);
    }

    private int calculateDiff(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff;
    }
}
