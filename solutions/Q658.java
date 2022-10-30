import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();

        // a min heap to store the len-k farest points
        // as arr is sorted, the seq of popped elements must be sorted
        Queue<Integer> minheap = new PriorityQueue<>(
                (e1, e2) -> {
                    if (Math.abs(x - e1) != Math.abs(x - e2)) {
                        return Math.abs(x - e1) - Math.abs(x - e2);
                    } else {
                        return e1 - e2;
                    }
                });

        for (int i = 0; i < arr.length-k; i++) {
            minheap.add(arr[i]);
        }
        for (int i = arr.length-k; i < arr.length; i++) {
            minheap.add(arr[i]);
            int temp = minheap.poll();
            if (results.isEmpty()){
                results.add(temp);
            } else if (temp <= results.get(0)){
                results.add(0, temp);
            } else {
                results.add(temp);
            }
        }

        return results;
    }
}
