import java.util.ArrayList;
import java.util.List;

public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (level.size()!=0){
            results.add(level.get(level.size()-1).val);
            ArrayList<TreeNode> next_level = new ArrayList<>();
            for (TreeNode cur : level){
                if (cur.left != null){
                    next_level.add(cur.left);
                }
                if (cur.right != null){
                    next_level.add(cur.right);
                }
            }
            level = next_level;
        }
        return results;
    }
}
