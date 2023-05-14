import java.util.*;;

public class Q106 {
    HashMap<Integer, Integer> inIn;
    int[] postorder;
    int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        this.inIn = new HashMap<>();

        for (int i=0; i<inorder.length; i++){
            inIn.put(inorder[i], i);
        }
        return build(0, postorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int postStart, int postEnd, int inStart, int inEnd){
        if (postStart > postEnd){
            return null;
        }

        TreeNode cur = new TreeNode(postorder[postEnd]);
        int index = inIn.get(postorder[postEnd]);
        int leftSize = index - inStart;

        cur.left = build(postStart, postStart + leftSize-1, inStart, index-1);
        cur.right = build(postStart + leftSize, postEnd-1, index+1, inEnd);

        return cur;
    }
}
