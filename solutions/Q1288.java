import java.util.Arrays;

public class Q1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int start = -1;
        int end = -1;
        int coverred = 0;

        for (int[] interval : intervals) {
            if (interval[1] <= end) {
                coverred++;
            } else if (interval[0] <= end) {
                end = interval[1];
            } else {
                start = interval[0];
                end = interval[1];
            }
        }

        return intervals.length - coverred;
    }
}
