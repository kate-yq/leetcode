import java.util.*;

class Q399 {
    HashMap<String, HashMap<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.graph = new HashMap<>();
        for (int i=0; i<equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];

            if (!graph.containsKey(a)){
                graph.put(a, new HashMap<>());
            }
            if (!graph.containsKey(b)){
                graph.put(b, new HashMap<>());
            }
            graph.get(a).put(b, v);
            graph.get(b).put(a, 1/v);
        }

        double[] ans = new double[queries.size()];
        for (int i=0; i<queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)){
                ans[i] = -1.0;
            } else {
                ans[i] = dfs(a, b, 1, new HashSet<>());
            }
        }

        return ans;
    }

    private double dfs(String start, String end, double cur, HashSet<String> visited){
        if (start.equals(end)){
            return cur;
        }

        visited.add(start);
        double res = -1.0;
        for (String next : graph.get(start).keySet()){
            if (visited.contains(next)){
                continue;
            }
            res = dfs(next, end, cur * graph.get(start).get(next), visited);
            if (res != -1.0){
                break;
            }
        }

        visited.remove(start);
        return res;
    }
}