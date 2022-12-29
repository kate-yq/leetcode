public class Q285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode parent = null;
        // locate p
        while(cur.val!=p.val){
            if (cur.val<p.val){
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        // search right sub
        cur = cur.right;
        if (cur == null){
            return parent;
        }
        while (cur.left != null){
            cur = cur.left;
        }
        return cur;
    }
}
