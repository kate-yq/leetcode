import java.util.*;;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int[] ans  = new int[2];
        for (int i=0; i<nums.length; i++){
            if (indices.containsKey(target-nums[i])){
                ans[0] = indices.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            indices.put(nums[i], i);
        }
        return ans;
    }
}
