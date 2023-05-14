import java.util.*;

public class Q652 {
    HashMap<String, Integer> trees;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.trees = new HashMap<>();
        this.ans = new ArrayList<>();

        search(root);

        return ans;
    }

    private String search(TreeNode cur){
        if (cur == null){
            return "";
        }

        String curTree = search(cur.left) + "," + search(cur.right) + "," + cur.val;

        int freq = trees.getOrDefault(curTree, 0);

        if (freq == 1){
            ans.add(cur);
        }

        trees.put(curTree, freq+1);

        return curTree;
    }
}
