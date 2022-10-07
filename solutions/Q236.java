import java.util.ArrayList;

public class Q236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p_parents = new ArrayList<>();
        ArrayList<TreeNode> q_parents = new ArrayList<>();

        _search(root, p.val, p_parents);
        _search(root, q.val, q_parents);

        int len = Math.min(p_parents.size(), q_parents.size());
        int parent = 0;
        for (int i = 1; i<=len; i++){
            if (p_parents.get(p_parents.size()-i).val==q_parents.get(q_parents.size()-i).val){
                parent = p_parents.size()-i;
            } else {
                break;
            }
        }
        return p_parents.get(parent);
    }

    private boolean _search(TreeNode cur, int target, ArrayList<TreeNode> parents){
        if (cur == null){
            return false;
        }
        if (cur.val == target){
            parents.add(cur);
            return true;
        } else {
            if (_search(cur.left, target, parents)){
                parents.add(cur);
                return true;
            }
            if (_search(cur.right, target, parents)){
                parents.add(cur);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        Q236 lCA = new Q236();
        System.out.println(lCA.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
