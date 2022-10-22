import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
        // Pair of node and its column offset
        Queue<Pair> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair(root, column));   // same as add

        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }

        for (int i = minColumn; i < maxColumn + 1; i++) {
            output.add(columnTable.get(i));
        }

        return output;
    }

    private class Pair{
        TreeNode key;
        Integer value;
        public Pair(TreeNode a, Integer b){
            this.key = a;
            this.value = b;
        }

        public TreeNode getKey(){
            return this.key;
        }
        public Integer getValue(){
            return this.value;
        }
    }

}


