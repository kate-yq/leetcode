import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // edge cases
        if (n <= 2) {
            ArrayList<Integer> results = new ArrayList<>();
            for (int i = 0; i < n; i++)
                results.add(i);
            return results;
        }

        // build the graph
        HashMap<Integer, HashSet<Integer>> adjcent = new HashMap<>();
        for (int i=0; i<n; i++){
            adjcent.put(i, new HashSet<>());
        }
        for (int i=0; i<edges.length; i++){
            adjcent.get(edges[i][0]).add(edges[i][1]);
            adjcent.get(edges[i][1]).add(edges[i][0]);
        }

        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (adjcent.get(i).size() == 1)
                leaves.add(i);

        // Trim the leaves until reaching the center
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with the edges
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer neighbor = adjcent.get(leaf).iterator().next();
                // remove the edge along with the leaf node
                adjcent.get(neighbor).remove(leaf);
                if (adjcent.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepare for the next round
            leaves = newLeaves;
        }

        // The remaining nodes are the centroids of the graph
        return leaves;
    }
}
