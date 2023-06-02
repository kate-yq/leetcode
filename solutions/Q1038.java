public class Q1038 {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
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
