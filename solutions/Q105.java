import java.util.HashMap;

// inoreder means 中根遍历， 即先访问左子树，再访问节点，最后访问右子树

public class Q105 {
    int[] preorder;
    HashMap<Integer, Integer> inorder_index;
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        this.preorder = preorder;
        this.inorder_index = new HashMap<>();
        for (int i = 0; i<inorder.length; i++){
            inorder_index.put(inorder[i], i);
        }
        return arrayToTree(0, preorder.length-1);
    }

    private TreeNode arrayToTree(int left, int right){
        if (left>right){
            return null;
        }
        int root_value = this.preorder[this.index];
        this.index++;
        TreeNode root = new TreeNode(root_value);
        root.left = arrayToTree(left, this.inorder_index.get(root_value)-1);
        root.right = arrayToTree(this.inorder_index.get(root_value)+1, right);
        return root;
    }
}
