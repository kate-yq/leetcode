import java.util.*;

public class Q1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // topo sort
        // same group together
        // inner group sequence and inter-group sequence

        // sort group first
        // sort inner item later

        // key - group number, if key >= m, no group item
        Map<Integer, List<Integer>> groupToItem = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (group[i] != -1) {
                groupToItem.putIfAbsent(group[i], new ArrayList<>());
                groupToItem.get(group[i]).add(i);
            } else {
                groupToItem.put(m + i, new ArrayList<>());
                groupToItem.get(m + i).add(i);
            }
        }

        // key - item number, value - to item number
        Map<Integer, List<Integer>> innerGroup = new HashMap<>();

        // key - group number, value - to group number
        Map<Integer, List<Integer>> interGroup = new HashMap<>();

        // sort group
        int[] indegree = new int[m + n];
        for (int i = 0; i < n; i++) {
            int toGroup = group[i] == -1 ? m + i : group[i];
            for (int from : beforeItems.get(i)) {
                int fromGroup = group[from] == -1 ? m + from : group[from];
                if (fromGroup == toGroup) {
                    innerGroup.putIfAbsent(from, new ArrayList<>());
                    innerGroup.get(from).add(i);
                } else {
                    interGroup.putIfAbsent(fromGroup, new ArrayList<>());
                    interGroup.get(fromGroup).add(toGroup);
                    indegree[toGroup]++;
                }
            }
        }

        List<Integer> groupSeq = new ArrayList<>();
        Queue<Integer> groupQueue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                groupQueue.add(i);
            }
        }

        while (!groupQueue.isEmpty()) {
            int cur = groupQueue.poll();
            groupSeq.add(cur);
            if (!interGroup.containsKey(cur)) {
                continue;
            }
            for (int nextGroup : interGroup.get(cur)) {
                indegree[nextGroup]--;
                if (indegree[nextGroup] == 0) {
                    groupQueue.add(nextGroup);
                }
            }
        }

        if (groupSeq.size() != m + n) {
            return new int[0];
        }

        int[] ans = new int[n];
        int index = 0;
        for (int groupNo : groupSeq) {
            if (!groupToItem.containsKey(groupNo)) {
                continue;
            }
            if (groupToItem.get(groupNo).size() == 1) {
                ans[index] = groupToItem.get(groupNo).get(0);
                index++;
            } else {
                if (!fillGroup(innerGroup, groupToItem, ans, index, groupNo)) {
                    return new int[0];
                }
                ;
                index += groupToItem.get(groupNo).size();
            }
        }

        return ans;
    }

    private boolean fillGroup(Map<Integer, List<Integer>> innerGroup,
            Map<Integer, List<Integer>> groupToItem,
            int[] ans, int start, int groupNo) {

        Map<Integer, Integer> indegree = new HashMap<>();
        for (int item : groupToItem.get(groupNo)) {
            indegree.putIfAbsent(item, 0);
            if (!innerGroup.containsKey(item)) {
                continue;
            }

            for (int to : innerGroup.get(item)) {
                indegree.put(to, indegree.getOrDefault(to, 0) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int item : indegree.keySet()) {
            if (indegree.get(item) == 0) {
                queue.add(item);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[start] = cur;
            start++;

            if (!innerGroup.containsKey(cur)) {
                continue;
            }
            for (int to : innerGroup.get(cur)) {
                int degree = indegree.get(to) - 1;
                indegree.put(to, degree);
                if (degree == 0) {
                    queue.add(to);
                }
            }
        }

        for (int item : indegree.keySet()) {
            if (indegree.get(item) > 0) {
                return false;
            }
        }

        return true;
    }
}
