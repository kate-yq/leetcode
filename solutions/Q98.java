public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return _findRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean _findRange(TreeNode cur, long min, long max){
        if (cur == null){
            return true;
        } else if (cur.val >= max || cur.val <= min){
            return false;
        } else {
            return _findRange(cur.left, min, cur.val) && _findRange(cur.right, cur.val, max);
        }
    }
}
