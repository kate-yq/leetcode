import java.util.Stack;

class Q1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Stack<Node> p_parents = new Stack<>();
        Stack<Node> q_parents = new Stack<>();
        while (p != null) {
            p_parents.push(p);
            p = p.parent;
        }
        while (q != null) {
            q_parents.push(q);
            q = q.parent;
        }
        
        Node temp = p_parents.pop();
        Node parent = temp;
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