import java.util.Stack;

class Q1650 {
    public TreeNode2 lowestCommonAncestor(TreeNode2 p, TreeNode2 q) {
        Stack<TreeNode2> p_parents = new Stack<>();
        Stack<TreeNode2> q_parents = new Stack<>();
        while (p != null) {
            p_parents.push(p);
            p = p.parent;
        }
        while (q != null) {
            q_parents.push(q);
            q = q.parent;
        }
        
        TreeNode2 temp = p_parents.pop();
        TreeNode2 parent = temp;
        while (temp.val == q_parents.pop().val){
            parent = temp;
            if (!p_parents.isEmpty() && !q_parents.isEmpty()){
                temp = p_parents.pop();
            } else {
                break;
            }
        }
        return parent;
    }
}