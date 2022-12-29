import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] results = new int[numCourses];
        int index = 0;
        // build a graph
        HashMap<Integer, HashSet<Integer>> nextclass = new HashMap<>();
        for (int i=0; i<numCourses; i++){
            nextclass.put(i, new HashSet<Integer>());
        }
        // calculate in-degree
        int[] indegree = new int[numCourses];
        for (int i=0; i<prerequisites.length; i++){
            nextclass.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> bfs = new LinkedList<Integer>();
        for (int i=0; i<indegree.length; i++){
            if (indegree[i] == 0){
                bfs.add(i);
            }
        }
        while (!bfs.isEmpty()){
            int course = bfs.poll();
            results[index] = course;
            index++;
            for (int next: nextclass.get(course)){
                indegree[next]--;
                if (indegree[next]==0){
                    bfs.add(next);
                }
            }
        }
        if (index < numCourses){
            return new int[0];
        }
        return results;
    }
}
