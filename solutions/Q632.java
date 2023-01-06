import java.util.List;
import java.util.PriorityQueue;

public class Q632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] range = new int[2];
        range[0] = Integer.MAX_VALUE;
        range[1] = Integer.MIN_VALUE;
        // int[] = {list index, element val}
        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        // initialize, and remove first element
        for (int i=0; i<nums.size(); i++){
            int val = nums.get(i).get(0);
            nums.get(i).remove(0);
            minheap.add(new int[]{i, val});
            if (val< range[0]){
                range[0] = val;
            }
            if (val> range[1]){
                range[1] = val;
            }
        }

        int min = range[0];
        int max = range[1];
        while(true){
            int[] cur = minheap.poll();
            if (nums.get(cur[0]).size()==0){
                break;
            }
            int val = nums.get(cur[0]).get(0);
            nums.get(cur[0]).remove(0);
            minheap.add(new int[]{cur[0], val});
            if (val<=max){
                min = minheap.peek()[1];
            } else if (val>max){
                max = val;
                min = minheap.peek()[1];
            }
            if (max-min < range[1]-range[0]){
                range[1] = max;
                range[0] = min;
            }
        }
        return range;
    }
}
