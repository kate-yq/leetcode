import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // corner case:
        if (src == dst){
            return 0;
        }

        // build a graph
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for (int[] flight : flights){
            if (!map.containsKey(flight[0])){
                map.put(flight[0], new ArrayList<int[]>());
            }
            map.get(flight[0]).add(flight);
        }

        // record the current lowest price of each stop
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        int stop = 0;

        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{src, 0});

        // bfs
        while (!bfs.isEmpty() && stop<=k){
            int num = bfs.size();
            while(num > 0){
                int[] temp = bfs.poll();
                num--;
                if (!map.containsKey(temp[0])){
                    continue;
                }
                for (int[] next:map.get(temp[0])){
                    if (next[2]+temp[1]<prices[next[1]]){
                        prices[next[1]] = next[2]+temp[1];
                        bfs.add(new int[]{next[1], prices[next[1]]});
                    }
                }
            }
            stop++;
        }
        if (prices[dst]==Integer.MAX_VALUE){
            return -1;
        } else {
            return prices[dst];
        }
    }
}
