public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode cur, int val1, int val2){
        if (cur == null){
            return null;
        }
        
        if (cur.val == val1 || cur.val == val2){
            return cur;
        }

        TreeNode l = find(cur.left, val1, val2);
        TreeNode r = find(cur.right, val1, val2);
        if (l!= null && r!= null){
            return cur;
        }

        return l == null? r:l;
    }
}
