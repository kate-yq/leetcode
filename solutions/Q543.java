public class Q543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int cur = findHeight(root.left) + findHeight(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(Math.max(left, right),cur);
    }

    private int findHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }
        return Math.max(findHeight(current.left), findHeight(current.right))+1;
    }
}
