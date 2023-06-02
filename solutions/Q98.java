public class Q98 {
    public boolean isValidBST(TreeNode root) {
        // return _findRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return validate(root, null, null);
    }

    // private boolean _findRange(TreeNode cur, long min, long max){
    //     if (cur == null){
    //         return true;
    //     } else if (cur.val >= max || cur.val <= min){
    //         return false;
    //     } else {
    //         return _findRange(cur.left, min, cur.val) && _findRange(cur.right, cur.val, max);
    //     }
    // }

    private boolean validate(TreeNode cur, TreeNode min, TreeNode max){
        if (cur == null){
            return true;
        }
        if (min != null && cur.val <= min.val){
            return false;
        }
        if (max != null && cur.val >= max.val){
            return false;
        }

        return validate(cur.left, min, cur) && validate(cur.right, cur, max);
    }
}
