import java.util.*;

public class Q2813 {
    public long findMaximumElegance(int[][] items, int k) {
        if (items.length < k) {
            return 0;
        }

        // sort price descending
        Arrays.sort(items, (a, b) -> b[0] - a[0]);

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<int[]> stack = new Stack<>();

        // select first k
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += items[i][0];
            map.put(items[i][1], map.getOrDefault(items[i][1], 0) + 1);
            stack.push(items[i]);
        }

        long max = sum + 1L * map.size() * map.size();

        // check if another can swap the last non-single element in stack
        for (int i = k; i < items.length; i++) {
            // only add new element if the element is unique in the list
            // thus the number might increase
            while (!map.containsKey(items[i][1]) && !stack.isEmpty()) {
                int freq = map.get(stack.peek()[1]);
                if (freq > 1) {
                    // swap in the number
                    max = Math.max(max, (sum += items[i][0] - stack.peek()[0]) + (map.size() + 1L) * (map.size() + 1));
                    map.put(stack.peek()[1], freq - 1);
                    map.put(items[i][1], 1);

                    stack.pop();
                    stack.push(items[i]);
                    break;
                }
                stack.pop();
            }
        }
        return max;
    }
}
