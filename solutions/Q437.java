public class Q437 {
    // best solution:
    // using prefix sum
    // calculate each node's sum to the leaf
    // then check if there is any difference along the path equals
    // the target
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        int amount = search(root, targetSum, 0);
        return amount + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int search(TreeNode cur, long target, int existing_path){
        if (cur == null){
            return existing_path;
        }
        if (cur.val == target){
            existing_path++;
        }
        existing_path = search(cur.left, target-cur.val, existing_path);
        existing_path = search(cur.right, target-cur.val, existing_path);
        return existing_path;
    }
}
