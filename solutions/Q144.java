import java.util.*;

class Q144{
    List<Integer> preorder;

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder = new ArrayList<>();
        traverse(root);
        return preorder;
    }

    private void traverse(TreeNode cur){
        if (cur == null){
            return;
        }
        preorder.add(cur.val);
        traverse(cur.left);
        traverse(cur.right);
    }
}