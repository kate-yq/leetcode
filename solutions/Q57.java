import java.util.ArrayList;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0){
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }

        ArrayList<int[]> aux = new ArrayList<>();
        int[] affected = new int[2];
        int index = 0;
        while (index<intervals.length && intervals[index][1]<newInterval[0]){
            aux.add(intervals[index]);
            index++;
        }
        
        affected = newInterval;

        while (index<intervals.length && intervals[index][0]<=newInterval[1]){
            affected[0] = Math.min(affected[0], intervals[index][0]);
            affected[1] = Math.max(affected[1], intervals[index][1]);
            index++;
        }
        aux.add(affected);
        while(index<intervals.length){
            aux.add(intervals[index]);
            index++;
        }

        int[][] results = new int[aux.size()][2];
        for (int i=0; i<results.length; i++){
            results[i] = aux.get(i);
        }
        return results;
    }
}
