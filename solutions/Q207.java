import java.util.HashMap;
import java.util.HashSet;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses==1){
            return true;
        }

        // build a di-graph, pointing to the pre-requeisties
        HashMap<Integer, HashSet<Integer>> pres = new HashMap<>();
        for (int i=0; i<prerequisites.length; i++){
            if (pres.containsKey(prerequisites[i][1])){
                pres.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                HashSet<Integer> pre = new HashSet<Integer>();
                pre.add(prerequisites[i][0]);
                pres.put(prerequisites[i][1], pre);
            }
        }

        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int cur=0; cur<numCourses; cur++){
            if (isCycle(cur, pres, checked, path)){
                return false;
            }
        }
        return true;
    }

    private boolean isCycle(int cur, HashMap<Integer, HashSet<Integer>> pres, boolean[] checked, boolean[] path){
        // this course is checked before, and no cycle, then return false
        if (checked[cur]){
            return false;
        }

        // detect a cycle - previous passed course
        if (path[cur]){
            return true;
        }

        // no pre-requisite, must no cycle
        if (!pres.containsKey(cur)){
            return false;
        }

        // mark the start
        path[cur] = true;
        boolean cycle = false;
        // dfs
        for (int pre : pres.get(cur)){
            cycle = isCycle(pre, pres, checked, path);
            if (cycle) {
                return true;
            }
        }
        path[cur] = false;    // unmark when finish dfs
        checked[cur] = true;    // mark when complete and not found a cycle
        return false;
    }
}
