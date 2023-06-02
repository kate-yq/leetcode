public class Q538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode cur){
        if (cur == null){
            return;
        }
        traverse(cur.right);
        sum += cur.val;
        cur.val = sum;
        traverse(cur.left);
    }
}
