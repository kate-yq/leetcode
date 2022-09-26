/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Q108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode bst = new TreeNode();
        bst = fillnext(0, nums.length-1, nums);
        return bst;
    }
        
    private TreeNode fillnext(int lo, int hi, int[]nums){
        if (lo>hi){
            return null;
        }
        int index = (lo+hi)/2;
        TreeNode current = new TreeNode(nums[index]);
        current.left = fillnext(lo, index-1, nums);
        current.right = fillnext(index+1, hi, nums);
        return current;
    }
}