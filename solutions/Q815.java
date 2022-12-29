import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // corner case:
        if (source == target){
            return 0;
        }

        HashMap<Integer, HashSet<Integer>> bus_to_stop = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> stop_to_bus = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i=0; i<routes.length; i++){
            bus_to_stop.put(i, new HashSet<Integer>());
            for (int j=0; j<routes[i].length; j++){
                bus_to_stop.get(i).add(routes[i][j]);
                if (!stop_to_bus.containsKey(routes[i][j])){
                    stop_to_bus.put(routes[i][j], new HashSet<Integer>());
                }
                stop_to_bus.get(routes[i][j]).add(i);
            }
        }

        // corner case:
        if (!stop_to_bus.containsKey(source)){
            return -1;
        }

        Queue<Integer> prev_bus = new LinkedList<>();
        Queue<Integer> next_bus = new LinkedList<>();
        int ans = 0;
        for (int bus : stop_to_bus.get(source)){
            next_bus.add(bus);
            visited.add(bus);
        }
        while (!next_bus.isEmpty()) {
            prev_bus = next_bus;
            next_bus = new LinkedList<>();
            ans++;
            while (!prev_bus.isEmpty()){
                int bus = prev_bus.poll();
                for (int stop : bus_to_stop.get(bus)){
                    if (stop == target){
                        return ans;
                    }
                    for (int nextbus : stop_to_bus.get(stop)){
                        if (!visited.contains(nextbus)){
                            next_bus.add(nextbus);
                            visited.add(nextbus);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
