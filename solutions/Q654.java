public class Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        if (start == end){
            return new TreeNode(nums[start]);
        }

        int maxIndex = start;

        for (int i=start+1; i<=end; i++){
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }

        TreeNode cur = new TreeNode(nums[maxIndex]);
        cur.left = build(nums, start, maxIndex-1);
        cur.right = build(nums, maxIndex+1, end);

        return cur;
    }
}
