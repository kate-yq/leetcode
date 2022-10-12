import java.util.ArrayList;

public class Q230 {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        _inorder(root, inorder, k);
        return inorder.get(k-1);
    }

    private void _inorder(TreeNode cur, ArrayList<Integer> inorder, int k){
        if (cur==null){
            return;
        }
        if (inorder.size()==k){
            return;
        }
        _inorder(cur.left, inorder, k);
        inorder.add(cur.val);
        _inorder(cur.right, inorder, k);
        return;
    }
}
