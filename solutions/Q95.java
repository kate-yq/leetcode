import java.util.*;

public class Q95 {

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int lo, int hi){
        List<TreeNode> ans = new ArrayList<>();

        if (lo > hi){
            ans.add(null);
            return ans;
        }

        for (int i=lo; i<=hi; i++){
            List<TreeNode> left = build(lo, i-1);
            List<TreeNode> right = build(i+1, hi);
            for (TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode cur = new TreeNode(i, l, r);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
}
