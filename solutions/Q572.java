class Q572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        if (_isEqual(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean _isEqual(TreeNode cur, TreeNode target){
        if (cur == null && target == null){
            return true;
        } else if (cur == null || target == null){
            return false;
        } else if (cur.val != target.val){
            return false;
        } else {
            return _isEqual(cur.left, target.left) && _isEqual(cur.right, target.right);
        }
    }
}