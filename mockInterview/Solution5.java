public class Solution5 {

    public TreeNode mergeTree(TreeNode root1, TreeNode root2){
        // iterate all nodes, with same position
        // 1. if both not empty, add up -> further left, right
        // 2. if one is empty, attach the non-empty node  -> no further
        // 3. if both empty, append null -> no further 

        // 2 & 3, if one of them is null, append the other one
        
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode newroot = new TreeNode();
        newroot.val = root1.val + root2.val;
        newroot.left = mergeTree(root1.left, root2.left);
        newroot.right = mergeTree(root1.right, root2.right);

        return newroot;

        // time complexity: O(max(m,n))
        // space complexity: O(m+n)

        //    1
        //   / \
        //  2   2
        // /     \
        //3       3

        // 1
        //  \
        //   2
        //    \ 
        //     3
    }
}