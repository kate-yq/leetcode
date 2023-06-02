public class Q1644 {
    boolean findP = false;
    boolean findQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = find(root, p.val, q.val);
        if (!findP || !findQ){
            return null;
        }

        return ans;
    }

    private TreeNode find(TreeNode cur, int val1, int val2){
        if (cur ==  null){
            return null;
        }

        TreeNode l = find(cur.left, val1, val2);
        TreeNode r = find(cur.right, val1, val2);
        if (l!= null && r!= null){
            return cur;
        }
        if (cur.val == val1){
            findP = true;
            return cur;
        }
        if (cur.val == val2){
            findQ = true;
            return cur;
        }
        return l==null? r:l;
    }
}
