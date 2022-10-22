import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q987 {
    Queue<int[]> nodeIndex;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        this.nodeIndex = new PriorityQueue<>(
            (e1, e2) -> {
            // int[3]: [0]-col, [1]-row, [2]-node.val
            for (int i=0; i<3; i++){
                if (e1[i]!=e2[i]){
                    return e1[i] - e2[i];
                }
            }
            return 0;
        });

        _dfs(root, 0, 0);

        int cur_col = Integer.MIN_VALUE;
        while (!nodeIndex.isEmpty()){
            int[] temp = nodeIndex.poll();
            if (temp[0]!= cur_col){
                result.add(new ArrayList<Integer>());
                cur_col = temp[0];
            }
            result.get(result.size()-1).add(temp[2]);
        }

        return result;
    }

    private void _dfs(TreeNode cur, int col, int row){
        if (cur == null){
            return;
        }
        this.nodeIndex.add(new int[]{col, row, cur.val});
        _dfs(cur.left, col-1, row+1);
        _dfs(cur.right, col+1, row+1);
    }
}
