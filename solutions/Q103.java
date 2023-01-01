import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        ArrayList<TreeNode> level = new ArrayList<>();
        boolean backwards = false;
        level.add(root);
        while (!level.isEmpty()){
            ArrayList<TreeNode> nextlevel = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            if (!backwards){
                for (TreeNode cur : level){
                    if (cur.left != null){
                        nextlevel.add(cur.left);
                    }
                    if (cur.right != null){
                        nextlevel.add(cur.right);
                    }
                    result.add(cur.val);
                }
            } else {
                Stack<Integer> back = new Stack<>();
                for (TreeNode cur : level){
                    if (cur.left != null){
                        nextlevel.add(cur.left);
                    }
                    if (cur.right != null){
                        nextlevel.add(cur.right);
                    }
                    back.add(cur.val);
                }
                while (!back.isEmpty()){
                    result.add(back.pop());
                }
            }
            results.add(new ArrayList<>(result));
            level = nextlevel;
            backwards = !backwards;
        }
        return results;
    }
}
