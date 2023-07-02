import java.util.*;

public class Q698 {
    HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;

        return backtrack(k, 0, 0, 0, target, nums);
    }

    private boolean backtrack(int remaing, int bucketSum, int start, int mark, int target, int[] nums) {
        if (remaing == 0) {
            return true;
        }

        if (bucketSum == target) {
            boolean res = backtrack(remaing - 1, 0, 0, mark, target, nums);
            memo.put(mark, res);
            return res;
        }

        if (memo.containsKey(mark)) {
            return memo.get(mark);
        }

        for (int i = start; i < nums.length; i++) {
            if (((mark >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + bucketSum > target) {
                continue;
            }

            bucketSum += nums[i];
            mark += (1 << i);
            if (backtrack(remaing, bucketSum, i + 1, mark, target, nums)) {
                return true;
            }
            bucketSum -= nums[i];
            mark -= (1 << i);
        }

        return false;
    }
}
