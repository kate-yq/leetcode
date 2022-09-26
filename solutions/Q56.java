import java.util.ArrayList;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        // sort intervals according to the start point
        java.util.Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        // iterate according to indexs & generate result
        ArrayList<int[]> result = new ArrayList<int[]>();
        int[] temp = new int[2];
        temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                result.add(temp);
                temp = intervals[i];
            }
        }
        result.add(temp);
        int[][] results = new int[result.size()][];
        int index = 0;
        for (int[] span : result) {
            results[index] = span;
            index++;
        }

        return results;
    }

    public static void main(String[] args) {
        int[][] test_case_1 = {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        };
        int[][] test_case_2 = {
                { 4, 7 }, { 2, 4 }
        };
        Q56 mI = new Q56();
        System.out.println("exp: [[1,6],[8,10],[15,18]]");
        for (int[] interval : mI.merge(test_case_1)) {
            System.out.printf("[%d,%d],", interval[0], interval[1]);
        }
        System.out.println();
        System.out.println("exp: [[2,7]]");
        for (int[] interval : mI.merge(test_case_2)) {
            System.out.printf("[%d,%d],", interval[0], interval[1]);
        }
        System.out.println();
    }
}
