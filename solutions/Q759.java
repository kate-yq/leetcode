import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> results = new ArrayList<>();
        PriorityQueue<Interval> min_heap = new PriorityQueue<>(
            (e1, e2) -> {
                if (e1.start==e2.start){
                    return e1.end-e2.end;
                } else {
                    return e1.start-e2.start;
                }
            });

        for (List<Interval> employee : schedule){
            for (Interval timeslot : employee){
                min_heap.add(timeslot);
            }
        }
        int start = min_heap.poll().end;
        int end = Integer.MAX_VALUE;
        while(!min_heap.isEmpty()){
            Interval earliest = min_heap.poll();
            if (earliest.start < end){
                end = earliest.start;
                if (end > start){
                    Interval slot = new Interval(start, end);
                    results.add(slot);
                    start = Math.max(start, earliest.end);
                    end = Integer.MAX_VALUE;
                } else {
                    start = Math.max(start, earliest.end);
                    end = Integer.MAX_VALUE;
                }
            } else {
                start = Math.max(start, earliest.end);
                end = Integer.MAX_VALUE;
            }
        }
        return results;
    }
}
