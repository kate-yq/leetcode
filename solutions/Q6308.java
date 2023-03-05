import java.util.*;

public class Q6308 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        
        Queue<TreeNode> bfs = new LinkedList<>();
        
        bfs.add(root);
        while (!bfs.isEmpty()){
            Queue<TreeNode> nextlevel = new LinkedList<>();
            long sum = 0;
            while(!bfs.isEmpty()){
                TreeNode cur = bfs.poll();
                sum += cur.val;
                if (cur.left != null){
                    nextlevel.add(cur.left);
                }
                if (cur.right != null){
                    nextlevel.add(cur.right);
                }
            }
            bfs = nextlevel;
            minheap.add(sum);
            if (minheap.size()>k){
                minheap.poll();
            }
        }
        if (minheap.size() < k){
            return -1;
        }
        return minheap.peek();
    }
}
