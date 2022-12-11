import java.util.LinkedList;
import java.util.Queue;

public class Q547 {
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        int[] visited = new int[N];
        Queue<Integer> bfs = new LinkedList<>();
        int current = 0;
        for (int i=0; i<N; i++){
            if (visited[i]>0){
                continue;
            }
            current++;
            bfs.add(i);
            visited[i] = current;
            while (!bfs.isEmpty()){
                int parent = bfs.poll();
                for (int j = 0; j<N; j++){
                    if(isConnected[parent][j]==1 && visited[j]==0){
                        visited[j]=current;
                        bfs.add(j);
                    }
                }
            }
        }
        return current;
    }
}
