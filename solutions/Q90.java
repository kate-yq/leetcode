import java.util.*;

public class Q90 {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<>());
        return ans;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> temp) {
        ans.add(new LinkedList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            backtrack(nums, i + 1, temp);
            temp.removeLast();
        }
    }

}
