public class Q104 {
    public int maxDepth(TreeNode root) {
        int max = _dfs(root, 0, 0);
        return max;
    }

    private int _dfs(TreeNode cur, int cur_depth, int max_depth){
        if (cur == null){
            return Math.max(cur_depth, max_depth);
        } else {
            return Math.max(_dfs(cur.left, cur_depth+1, max_depth), _dfs(cur.right, cur_depth+1, max_depth));
        }
    }
}
