public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        _switch(root);
        return root;
    }

    private void _switch(TreeNode cur){
        if (cur != null){
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        } else {
            return;
        }
        _switch(cur.left);
        _switch(cur.right);
    }
}
