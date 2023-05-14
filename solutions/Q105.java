import java.util.HashMap;

// inoreder means 中根遍历， 即先访问左子树，再访问节点，最后访问右子树

public class Q105 {
    HashMap<Integer, Integer> inIn;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.inIn = new HashMap<>();

        for (int i=0; i<inorder.length; i++){
            inIn.put(inorder[i], i);
        }
        return build(0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int preStart, int preEnd, int inStart, int inEnd){
        if (preStart > preEnd){
            return null;
        }

        TreeNode cur = new TreeNode(preorder[preStart]);
        int index = inIn.get(preorder[preStart]);
        int leftSize = index - inStart;
        cur.left = build(preStart+1, preStart + leftSize, inStart, index-1);
        cur.right = build(preStart + leftSize + 1, preEnd, index+1, inEnd);

        return cur;
    }
}
