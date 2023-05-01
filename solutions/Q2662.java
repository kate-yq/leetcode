import java.util.*;

public class Q2662 {
    public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // special road is one-way

        long v = 100001;

        // store all special roads and target
        Map<Long, List<Pair<Long, Integer>>> mp = new HashMap<>();
        mp.put(target[0] * v + target[1], new ArrayList<Pair<Long, Integer>>(Arrays.asList(new Pair<>(0L, 0))));
        
        for (int[] x : specialRoads) {
            long key = x[0] * v + x[1];
            long val = x[2] * v + x[3];
            int cost = x[4];
            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<Pair<Long, Integer>>());
            }
            mp.get(key).add(new Pair<>(val, cost));
        }
        
        // store all reacheable points in special roads and start, target, with their min cost
        Map<Long, Integer> dist = new HashMap<>();
        dist.put(start[0] * v + start[1], 0);

        // a min heap that use cost as key, index=>long as value
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.add(new Pair<>(0, start[0] * v + start[1]));
        
        while (!pq.isEmpty()) {
            Pair<Integer, Long> pair = pq.poll();
            int curCost = pair.getKey();
            long curIndex = pair.getValue();

            if (curIndex == target[0] * v + target[1]) {
                return curCost;
            }

            for (Pair<Long, Integer> road : mp.getOrDefault(curIndex, new ArrayList<Pair<Long, Integer>>())) {
                long end = road.getKey();
                int cost = road.getValue();
                if (!dist.containsKey(end) || curCost + cost < dist.get(end)) {
                    dist.put(end, curCost + cost);
                    pq.add(new Pair<>(curCost + cost, end));
                }
            }
            
            for (Map.Entry<Long, List<Pair<Long, Integer>>> entry : mp.entrySet()) {
                long index = entry.getKey();
                int cost = curCost + Math.abs((int)(index % v - curIndex % v)) + Math.abs((int)(index / v - curIndex / v));
                if (!dist.containsKey(index) || cost < dist.get(index)) {
                    dist.put(index, cost);
                    pq.add(new Pair<>(cost, index));
                }
            }
        }
        
        return -1;
    }
}
