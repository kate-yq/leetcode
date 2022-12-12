import java.util.Arrays;

public class Q252{
    public boolean canAttendMeetings(int[][] intervals) {
        // sort, O(n log n)
        Arrays.sort(intervals, (e1, e2)->{
            if (e1[0]==e2[0]){
                return e1[1]-e2[1];
            }
            return e1[0]-e2[0];
        });
        for (int i=0; i<intervals.length-1; i++){
            if (intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
