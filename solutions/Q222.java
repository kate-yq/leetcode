public class Q222 {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int hl = 0;
        int hr = 0;

        TreeNode cur = root;

        while (cur != null){
            hl++;
            cur = cur.left;
        }

        cur = root;

        while (cur != null){
            hr++;
            cur = cur.right;
        }

        if (hl == hr){
            return (int) Math.pow(2, hl) -1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
