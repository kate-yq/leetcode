import java.util.Arrays;

class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int gap = Math.abs(nums[0] + nums[1] + nums[2] - target); // get the initial gap
        int outcome = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] - target < 0) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < gap) {
                        gap = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        outcome = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                } else if (nums[i] + nums[j] + nums[k] - target > 0) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < gap) {
                        gap = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        outcome = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                } else {
                    return target;
                }
            }
        }
        return outcome;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        int tar = -1;
        Q16 find3sumcloest = new Q16();
        System.out.println(find3sumcloest.threeSumClosest(nums, tar));
    }
}