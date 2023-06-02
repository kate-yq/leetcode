public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        if (root.val == key){
            if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else {
                TreeNode minRight = getMin(root.right);
                root.right = deleteNode(root.right, minRight.val);
                minRight.left = root.left;
                minRight.right = root.right;
                root = minRight;
            }
        }

        return root;
    }

    private TreeNode getMin(TreeNode cur){
        while (cur.left != null){
            cur = cur.left;
        }
        return cur;
    }
}
