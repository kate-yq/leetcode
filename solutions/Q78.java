import java.util.ArrayList;
import java.util.List;

public class Q78 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, temp, 0);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> temp, int start){
        if (start == nums.length){
            results.add(new ArrayList<>(temp));
            return;
        }
        backtrack(nums, temp, start+1);
        temp.add(nums[start]);
        backtrack(nums, temp, start+1);
        temp.remove(temp.size()-1);
        return;
    }
}
