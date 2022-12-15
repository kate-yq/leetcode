import java.util.HashMap;
import java.util.PriorityQueue;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length-k+1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);
        for (int i=0; i<k; i++){
            if (freq.containsKey(nums[i])){
                freq.put(nums[i], freq.get(nums[i])+1);
            } else {
                freq.put(nums[i], 1);
            }
            heap.add(nums[i]);
            max[0] = heap.peek();
        }
        for (int i=k; i<nums.length; i++){
            if (freq.containsKey(nums[i])){
                freq.put(nums[i], freq.get(nums[i])+1);
            } else {
                freq.put(nums[i], 1);
            }
            heap.add(nums[i]);
            freq.put(nums[i-k], freq.get(nums[i-k])-1);
            max[i-k+1] = heap.peek();
            while (freq.get(max[i-k+1]) == 0) {
                heap.poll();
                max[i-k+1] = heap.peek();
            }
        }
        return max;
    }
}
