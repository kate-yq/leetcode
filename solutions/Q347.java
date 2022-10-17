import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length){
            return nums;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            if (freq.containsKey(nums[i])){
                freq.put(nums[i], freq.get(nums[i])+1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        // the build-in HEAP in java is min-heap
        // IMPORTANT: change the comparable rule from integer itself, to the frequency
        // normally, we create a new class implement comparable<class>, and add compareTo() to return 1, -1, 0
        // here, as Map is a build-in datastructure, so we simply change compare to within the ()
        Queue<Integer> heap = new PriorityQueue<>(
            (num1, num2) -> freq.get(num1)-freq.get(num2)
        );

        for (int num : freq.keySet()){
            heap.add(num);
            if (heap.size()>k){
                heap.poll();
            }
        }

        int[] top = new int[k];
        for (int i =0; i<k; i++){
            top[i] = heap.poll();
        }
        return top;
    }
}