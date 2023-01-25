import java.util.LinkedList;
import java.util.Queue;

public class Q1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        visited[start] = true;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(start);
        while (!bfs.isEmpty()){
            int cur = bfs.poll();
            if (cur - arr[cur]>=0 && !visited[cur-arr[cur]]){
                visited[cur-arr[cur]] = true;
                bfs.add(cur-arr[cur]);
            }
            if (cur + arr[cur]<n && !visited[cur+arr[cur]]){
                visited[cur+arr[cur]] = true;
                bfs.add(cur+arr[cur]);
            }
        }
        for (int i =0; i<n; i++){
            if (arr[i]==0 && visited[i]){
                return true;
            }
        }
        return false;
    }
}
