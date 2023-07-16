import java.util.*;

public class Q2780 {

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int n = nums.size();
        int[] preDom = new int[n];

        for (int i = 0; i < n; i++) {
            freq.put(nums.get(i), freq.getOrDefault(nums.get(i), 0) + 1);
            int[] cur = new int[] { nums.get(i), freq.get(nums.get(i)) };
            maxheap.add(cur);
            int f = maxheap.peek()[1];
            if (f * 2 > i + 1) {
                preDom[i] = maxheap.peek()[0];
            } else {
                preDom[i] = -1;
            }
        }

        freq.clear();
        maxheap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] postDom = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            freq.put(nums.get(i), freq.getOrDefault(nums.get(i), 0) + 1);
            int[] cur = new int[] { nums.get(i), freq.get(nums.get(i)) };
            maxheap.add(cur);
            int f = maxheap.peek()[1];
            if (f * 2 > n - i) {
                postDom[i] = maxheap.peek()[0];
            } else {
                postDom[i] = -1;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (preDom[i] == postDom[i + 1] && preDom[i] != -1) {
                return i;
            }
        }
        return -1;
    }
}
