import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1){
            return 1;
        }
        Arrays.sort(intervals, (e1, e2)-> e1[0] - e2[0]);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int rooms = 0;
        for (int i = 0; i<intervals.length; i++){
            // peek is to check the top value, not to pop the element
            if (heap.isEmpty() || heap.peek() > intervals[i][0]){
                rooms++;
            } else {
                heap.poll();
            }
            heap.add(intervals[i][1]);
        }
        return rooms;
    }
}
