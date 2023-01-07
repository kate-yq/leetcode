import java.util.HashMap;

public class Q337 {
    HashMap<TreeNode, Integer> maxincludingself;
    HashMap<TreeNode, Integer> maxnotincludingself;

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        this.maxincludingself = new HashMap<>();
        maxincludingself.put(null, 0);
        this.maxnotincludingself = new HashMap<>();
        maxnotincludingself.put(null, 0);
        findMax(root);
        
        return Math.max(maxincludingself.get(root), maxnotincludingself.get(root));
    }

    private void findMax(TreeNode cur){
        if (cur == null){
            return;
        }
        findMax(cur.left);
        findMax(cur.right);
        // simpler case: self.val + not self left + not self right
        int sumself = maxnotincludingself.get(cur.left) + maxnotincludingself.get(cur.right) + cur.val;
        maxincludingself.put(cur, sumself);
        // complicate case: not self
        // + larger of self||notself left
        // + self||notself right
        int sumnotself = Math.max(maxnotincludingself.get(cur.left), maxincludingself.get(cur.left)) + Math.max(maxnotincludingself.get(cur.right), maxincludingself.get(cur.right));
        maxnotincludingself.put(cur, sumnotself);
    }
}
