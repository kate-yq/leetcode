import java.util.HashSet;

public class Q1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> vals = new HashSet<>();
        for (TreeNode n : nodes){
            vals.add(n.val);
        }

        return find(root, vals);
    }

    private TreeNode find(TreeNode cur, HashSet<Integer> vals){
        if (cur == null){
            return null;
        }

        if(vals.contains(cur.val)){
            return cur;
        }

        TreeNode l = find(cur.left, vals);
        TreeNode r = find(cur.right, vals);

        if (l!= null && r!= null){
            return cur;
        }

        return l==null? r:l;
    }
}
