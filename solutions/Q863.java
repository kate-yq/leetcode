import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q863 {
    List<Integer> results = new ArrayList<>();
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null){
            return results;
        }
        recordAllParent(root);
        TreeNode cur = target;
        godown(cur, k);
        while(parent.containsKey(cur) && k>0){
            godown(parent.get(cur), k-1);
            cur = parent.get(cur);
            k--;
        }
        return results;
    }

    private void recordAllParent(TreeNode cur){
        if (cur.left != null){
            this.parent.put(cur.left, cur);
            recordAllParent(cur.left);
        }
        if (cur.right != null){
            this.parent.put(cur.right, cur);
            recordAllParent(cur.right);
        }
    }

    private void godown(TreeNode cur, int step){
        if (step < 0 || visited.contains(cur) || cur == null){
            return;
        }
        if (step == 0 && !visited.contains(cur)){
            results.add(cur.val);
        }
        visited.add(cur);
        godown(cur.left, step-1);
        godown(cur.right, step-1);
    }
}
