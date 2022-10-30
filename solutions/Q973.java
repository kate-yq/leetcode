import java.util.Queue;
import java.util.PriorityQueue;

public class Q973 {
    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }

        // build in PQ is a min-heap
        Queue<int[]> maxheap = new PriorityQueue<>(
                (e1, e2) -> (int) (Math.pow(e2[0], 2) + Math.pow(e2[1], 2) - Math.pow(e1[0], 2) - Math.pow(e1[1], 2)));
        for (int i = 0; i < k; i++) {
            maxheap.add(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            maxheap.add(points[i]);
            maxheap.poll();
        }

        int[][] closests = new int[k][2];
        for (int j = 0; j < k; j++) {
            closests[j] = maxheap.poll();
        }
        return closests;
    }

    public static void main(String[] args){
        int[][] test_case_1 = {
            {-5,4}, {-6,-5}, {4,6}
        };
        Q973 kc = new Q973();
        for (int[] point : kc.kClosest(test_case_1, 2)){
            System.out.println(point[0] +", "+point[1]);
        }
    }
}
