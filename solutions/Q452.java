import java.util.Arrays;

public class Q452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->{
            if (a[1]<b[1]){
                return -1;
            } else if (a[1]<b[1]){
                return 0;
            }
            return 1;
        });
        int count = 1;
        int end = points[0][1];
        for (int i=1; i<points.length; i++){
            if (points[i][0]>end){
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
