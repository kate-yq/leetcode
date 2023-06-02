import java.util.*;

public class Q1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] probFromStart = new double[n];
        probFromStart[start] = 1;

        HashMap<Integer, List<double[]>> graph = new HashMap<>();

        for (int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }

        PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> Double.compare(b.probFromStart, a.probFromStart));
        pq.add(new State(start, 1));
        
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curId = cur.id;
            double curProb = cur.probFromStart;

            if (curId == end){
                return curProb;
            }

            if (curProb < probFromStart[curId]){
                continue;
            }
            for (double[] next : graph.get(curId)){
                if (next[1]*curProb > probFromStart[(int)next[0]]){
                    probFromStart[(int)next[0]] = next[1]*curProb;
                    pq.add(new State((int) next[0], probFromStart[(int)next[0]]));
                }
            }
        }

        return 0.0;
    }

    class State{
        int id;
        double probFromStart;

        private State(int id, double probFromStart){
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }
}
