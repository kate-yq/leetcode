import java.util.HashMap;

public class Q124 {
    public int maxPathSum(TreeNode root) {
        // use 2 hash map to record left-max and right-max
        // then the max value of current node will be max(left, right, left+right-cur)

        HashMap<TreeNode, Integer> left_max = new HashMap<>();
        HashMap<TreeNode, Integer> right_max = new HashMap<>();
        _calculate(root, left_max, right_max);

        int max = Integer.MIN_VALUE;
        for (TreeNode x : left_max.keySet()){
            int temp = Math.max(Math.max(left_max.get(x), right_max.get(x)),left_max.get(x)+right_max.get(x)-x.val);
            max = Math.max(max, temp);
        }
        return max;
    }

    private void _calculate(TreeNode cur, HashMap<TreeNode, Integer> left_max, HashMap<TreeNode, Integer> right_max){
        if (cur == null){
            return;
        }

        if (cur.left == null){
            left_max.put(cur, cur.val);
        } else {
            _calculate(cur.left, left_max, right_max);
            left_max.put(cur, Math.max(Math.max(left_max.get(cur.left), right_max.get(cur.left))+cur.val, cur.val));
        }

        if (cur.right == null){
            right_max.put(cur, cur.val);
        } else {
            _calculate(cur.right, left_max, right_max);
            right_max.put(cur, Math.max(Math.max(left_max.get(cur.right), right_max.get(cur.right))+ cur.val, cur.val));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-2);
        Q124 mP = new Q124();
        
        System.out.println(mP.maxPathSum(root));
    }
}
