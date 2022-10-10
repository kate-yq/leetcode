import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Queue<TreeNode> prev_level = new LinkedList<>();
        prev_level.add(root);
        _bfs(prev_level, result);
        
        return result;
    }

    private void _bfs(Queue<TreeNode> prev_level, List<List<Integer>> result){
        if (prev_level.isEmpty()){
            return;
        }
        Queue<TreeNode> next_level = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        while (!prev_level.isEmpty()){
            TreeNode temp = prev_level.poll();
            level.add(temp.val);
            if (temp.left != null){
                next_level.add(temp.left);
            }
            if (temp.right != null){
                next_level.add(temp.right);
            }
        }
        result.add(level);
        _bfs(next_level, result);
    }
}
