import java.util.*;

class Q1110 {
    class Solution {
        List<TreeNode> res;
        Set<Integer> del;

        public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
            this.res = new ArrayList<>();
            this.del = new HashSet<>();

            for (int i : toDelete) {
                del.add(i);
            }

            root = dfs(root);
            if (root != null) {
                res.add(root);
            }
            return res;
        }

        private TreeNode dfs(TreeNode cur) {
            if (cur == null) {
                return null;
            }
            cur.left = dfs(cur.left);
            cur.right = dfs(cur.right);
            if (del.contains(cur.val)) {
                if (cur.left != null)
                    res.add(cur.left);
                if (cur.right != null)
                    res.add(cur.right);
                return null;
            }
            return cur;
        }
    }
}