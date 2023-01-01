import java.util.ArrayList;
import java.util.List;

public class Q113 {
    List<List<Integer>> results;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.results = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        search(root, targetSum, temp);
        return results;
    }

    private void search(TreeNode cur, int target, ArrayList<Integer> temp){
        if (cur == null){
            return;
        }
        temp.add(cur.val);
        if (cur.val == target && cur.left == null && cur.right == null){
            this.results.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        search(cur.left, target-cur.val, temp);
        search(cur.right, target-cur.val, temp);
        temp.remove(temp.size()-1);
    }
}
