public class Q110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.abs(left-right)<2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int findHeight(TreeNode cur){
        if (cur == null){
            return 0;
        }
        return Math.max(findHeight(cur.left), findHeight(cur.right))+1;
    }
}
