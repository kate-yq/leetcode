import java.util.*;;

public class Q889 {
    int[] preorder;
    int[] postorder;
    HashMap<Integer, Integer> postIn;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        this.postIn = new HashMap<>();

        for (int i=0; i<postorder.length; i++){
            postIn.put(postorder[i], i);
        }

        return build(0, preorder.length-1, 0, postorder.length-1);
    }

    private TreeNode build(int preStart, int preEnd, int postStart, int postEnd){
        if (preStart > preEnd){
            return null;
        }

        if (preStart==preEnd){
            return new TreeNode(preorder[preStart]);
        }

        TreeNode cur = new TreeNode(preorder[preStart]);

        int leftIndex = postIn.get(preorder[preStart+1]);
        int leftSize = leftIndex - postStart + 1;

        cur.left = build(preStart+1, preStart+leftSize, postStart, leftIndex);
        cur.right = build(preStart+leftSize+1, preEnd, leftIndex+1, postEnd-1);

        return cur;
    }
}
