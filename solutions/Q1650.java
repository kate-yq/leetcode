class Q1650 {
    public TreeNode2 lowestCommonAncestor(TreeNode2 p, TreeNode2 q) {
        TreeNode2 a = p;
        TreeNode2 b = q;

        while( a!= b){
            if(a == null){
                a = q;
            } else {
                a = a.parent;
            }
            if (b == null){
                b = p;
            } else {
                b = b.parent;
            }
        }
        return a;
    }
}