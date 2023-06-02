import java.util.*;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n-k+1];
        
        LinkedList<Integer> monoqueue = new LinkedList<>();

        for (int i=0; i<n; i++){
            if (i < k-1){
                while (!monoqueue.isEmpty() && monoqueue.getLast()<nums[i]){
                    monoqueue.removeLast();
                }
                monoqueue.add(nums[i]);
            } else {
                while (!monoqueue.isEmpty() && monoqueue.getLast()<nums[i]){
                    monoqueue.removeLast();
                }
                monoqueue.add(nums[i]);
                max[i-k+1] = monoqueue.getFirst();
                if (monoqueue.getFirst() == nums[i-k+1]){
                    monoqueue.removeFirst();
                }
            }
        }
        
        return max;
    }
}
