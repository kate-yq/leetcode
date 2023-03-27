import java.util.HashMap;

public class Q2597 {
    int sum;
    HashMap<Integer, Integer> set;
    int[] nums;

    public int beautifulSubsets(int[] nums, int k) {
        this.sum = 0;
        this.nums = nums;
        this.set = new HashMap<>();
        
        backtrack(0, k);

        return sum;
    }

    private void backtrack(int cur, int k){
        if (cur == nums.length){
            return;
        }
        if (set.containsKey(nums[cur]+k) || set.containsKey(nums[cur]-k)){
            backtrack(cur+1, k);
        } else {
            // choose
            if (set.containsKey(nums[cur])){
                set.put(nums[cur], set.get(nums[cur])+1);
            } else {
                set.put(nums[cur], 1);
            }
            sum++;
            backtrack(cur+1, k);

            // unchoose
            if (set.get(nums[cur]) == 1){
                set.remove(nums[cur]);
            } else {
                set.put(nums[cur], set.get(nums[cur])-1);
            }
            backtrack(cur+1, k);
        }
    }
}
