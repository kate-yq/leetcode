import java.util.*;

public class Q743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] disFromStart = new int[n+1];
        Arrays.fill(disFromStart, Integer.MAX_VALUE);
        disFromStart[k] = 0;


        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] time : times){
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)->a.disFromStart - b.disFromStart);

        pq.add(new State(k, 0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curId = cur.id;
            int curDis = cur.disFromStart;
            if (cur.disFromStart > disFromStart[curId]){
                continue;
            }
            for (int[] next : graph.get(curId)){
                if (curDis + next[1] < disFromStart[next[0]]){
                    disFromStart[next[0]] = curDis + next[1];
                    pq.add(new State(next[0], curDis + next[1]));
                }
            }
        }

        int maxT = 0;
        for (int i=1; i<=n; i++){
            if (disFromStart[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxT = Math.max(maxT, disFromStart[i]);
        }

        return maxT;
    }

    class State{
        int id;
        int disFromStart;

        private State(int id, int disFromStart){
            this.id = id;
            this.disFromStart = disFromStart;
        }
    }
}
